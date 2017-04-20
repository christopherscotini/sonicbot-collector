package com.gamaset.sonicbot.collector.business.probabilitymatch;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchTeamCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchTeamProbValueCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator.MatchValidatorComponent;
import com.gamaset.sonicbot.collector.business.statistic.ManagerProcessMatchStatistic;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.repository.CouponMatchRepository;
import com.gamaset.sonicbot.collector.repository.entity.Coupon;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeam;
import com.gamaset.sonicbot.collector.service.academia.match.MatchAcademiaService;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class ManagerProcessProbabilityMatchSchedule {

	private static final Logger LOG = LogManager.getLogger(ManagerProcessProbabilityMatchSchedule.class);

	@Autowired
	private CouponCreateProcessComponent couponCreateProcessComponent;
	@Autowired
	private CouponMatchCreateProcessComponent couponMatchCreateProcessComponent;
	@Autowired
	private CouponMatchTeamCreateProcessComponent couponMatchTeamCreateProcessComponent;
	@Autowired
	private CouponMatchTeamProbValueCreateProcessComponent couponMatchTeamProbValueCreateProcessComponent;
	@Autowired
	private MatchValidatorComponent matchValidatorComponent;
	@Autowired
	private MatchAcademiaService matchAcademiaService;
	@Autowired
	private ManagerProcessMatchStatistic matchStatistic;
	@Autowired
	private CouponMatchRepository couponMatchRepository;

	/**
	 * Metodo que faz a leitura dos jogos(por data) e das estatisticas no
	 * academia das apostas
	 * 
	 * @param date
	 * @return
	 */
	public List<MatchDataDTO> read(String date) {
		
		LOG.info(String.format("%n===== init process read matches in academia [%s] =====", DateUtils.getNowDateTimeFormatted()));
		
		MatchSeriesDTO matchSeries = matchAcademiaService.listByDate(date);
		List<MatchDataDTO> datas = new ArrayList<>();
			for (MatchResumeDTO matchResume : matchSeries.getMatches()) {
				matchResume.setDate(matchSeries.getDate());
				MatchStatisticDTO matchStatisticDTO = matchStatistic.generateStatistics(matchResume);
				datas.add(new MatchDataDTO(matchResume, matchStatisticDTO));
			}
		
		LOG.info(String.format("%n===== finished process read matches[%d] in academia [%s] =====", datas.size(), DateUtils.getNowDateTimeFormatted()));

		return datas;
	}
	
	/**
	 * 
	 * @param matchesData
	 */
	@Transactional
	public void save(List<MatchDataDTO> matchesData) {

		LOG.info(String.format("%n===== init process insert data in database %s =====", DateUtils.getNowDateTimeFormatted()));
		Coupon coupon = couponCreateProcessComponent.process(matchesData.get(0).getMatchResume().getDate());
		if(couponMatchRepository.findByCouponId(coupon.getId()).isEmpty()){//TODO trocar por stream() e setar num HashSet os ids dos jogos cadastrados e persistir somente os nao existentes
			for (MatchDataDTO matchDataDTO : matchesData) {

				if(couponMatchRepository.findById(matchDataDTO.getMatchResume().getMatchId()) != null){
					LOG.warn(String.format("%n===== discart because are exists match %s =====", matchDataDTO.getMatchResume().toString()));
					continue;
				}
				
				if (!matchValidatorComponent.validate(matchDataDTO)) {
					LOG.warn(String.format("%n===== discart match %s =====", matchDataDTO.getMatchResume().toString()));
					continue;
				}
	
				try {
					
					CouponMatch couponMatch = couponMatchCreateProcessComponent.process(coupon, matchDataDTO);
	
					CouponMatchTeam couponMatchHomeTeam = couponMatchTeamCreateProcessComponent.process(couponMatch,
							couponMatch.getHomeTeam());
					couponMatchTeamProbValueCreateProcessComponent.process(couponMatchHomeTeam,
							matchDataDTO.getMatchstatistics().getHomeTeamStats());
	
					CouponMatchTeam couponMatchAwayTeam = couponMatchTeamCreateProcessComponent.process(couponMatch,
							couponMatch.getAwayTeam());
					couponMatchTeamProbValueCreateProcessComponent.process(couponMatchAwayTeam,
							matchDataDTO.getMatchstatistics().getAwayTeamStats());
					
				} catch (ConstraintViolationException c) {
					LOG.error(c.getErrorCode() + " - " + c.getConstraintName());
				}
			}
		}
		LOG.info(String.format("%n===== finished process insert data in database %s =====", DateUtils.getNowDateTimeFormatted()));
	}

	/**
	 * 
	 * @param date
	 */
	@Transactional
	public void update(String date) {

		MatchSeriesDTO matchSeries = matchAcademiaService.listByDate(date);
		List<CouponMatch> matchesSavedDb = couponMatchRepository.findByCouponId(matchSeries.getId());
		for (int i = 0; i < matchesSavedDb.size(); i++) {
			CouponMatch couponMatch = matchesSavedDb.get(i);
			for (MatchResumeDTO matchResume : matchSeries.getMatches()) {
				if (matchResume.getMatchId().equals(couponMatch.getId())) {
					couponMatch.setMatchStatus(matchResume.getMatchStatus());
					couponMatch.setScoreHomeTeam(matchResume.getHomeTeamMatch().getScore());
					couponMatch.setScoreAwayTeam(matchResume.getAwayTeamMatch().getScore());
					couponMatch.setUpdatedDate(DateUtils.getNowDateTime());
					couponMatch.setWinnerTeam(couponMatch.getWinnerTeam());
					couponMatchRepository.update(couponMatch);
				}
			}
		}

	}

}
