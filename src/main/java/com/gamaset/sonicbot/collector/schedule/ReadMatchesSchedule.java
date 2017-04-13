package com.gamaset.sonicbot.collector.schedule;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gamaset.sonicbot.collector.business.probabilitymatch.ManagerProcessProbabilityMatchSchedule;
import com.gamaset.sonicbot.collector.business.statistic.ManagerProcessMatchStatistic;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.dto.MatchStatusEnum;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.repository.CouponMatchRepository;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.service.match.MatchService;

@Component
public class ReadMatchesSchedule {

	private final static Logger LOG = LogManager.getLogger(ReadMatchesSchedule.class);
	
	// ler as 03:00:00 
	private static final String CRON_CONFIG_STATS_MATCHES = "00 35 12 * * ?";
	// ler as 02:30:00 
	private static final String CRON_CONFIG_UPDATE_MATCHES = "00 55 12 * * ?";

	private static final String ZONE_CONFIG = "America/Sao_Paulo";
	
	@Autowired
	private MatchService matchService;
	@Autowired
	private ManagerProcessMatchStatistic matchStatistic;
	@Autowired
	private ManagerProcessProbabilityMatchSchedule probabilityMatch;
	@Autowired
	private CouponMatchRepository couponMatchRepository;
	
	@Scheduled(cron = CRON_CONFIG_STATS_MATCHES, zone=ZONE_CONFIG)
	public void executeReadMatchesAndPersist() {
		
//		String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
		String date = "2017-04-15";

		LOG.info(String.format("%n=== initializing read and save matches [%s] in [%s] ===", date, dateFormat.format(new Date())));
		
		MatchSeriesDTO matchSeries = matchService.listByDate(date);
		List<MatchDataDTO> datas = new ArrayList<>();
		for (MatchResumeDTO matchResume : matchSeries.getMatches()) {
			matchResume.setDate(matchSeries.getDate());
			MatchStatisticDTO matchStatisticDTO = matchStatistic.generateStatistics(matchResume);
			datas.add(new MatchDataDTO(matchResume, matchStatisticDTO));
		}
		
		probabilityMatch.save(datas);
		
		LOG.info(String.format("%n=== finished read and save matches [%s] in [%s] ===", date, dateFormat.format(new Date())));
	}
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//TODO: REFATORAR
	@Scheduled(cron = CRON_CONFIG_UPDATE_MATCHES, zone=ZONE_CONFIG)
	@Transactional
	public void executeReadMatchesAndUpdateResults() {
		
//		String date = DateUtils.getTodayMinus1DayDateString();
		String date = "2017-04-15";
		LOG.info(String.format("%n=== initializing read and update matches results [%s] in [%s] ===", date, dateFormat.format(new Date())));
		
		MatchSeriesDTO matchSeries = matchService.listByDate(date);
		List<CouponMatch> matches = couponMatchRepository.findByCouponId(matchSeries.getId());
		for (int i = 0; i < matches.size(); i++) {
			CouponMatch couponMatch = matches.get(i);
			for (MatchResumeDTO matchResume : matchSeries.getMatches()	) {
				if(matchResume.getMatchStatus().equals(MatchStatusEnum.TERMINADO)){
					if(matchResume.getMatchId().equals(couponMatch.getId())){
							
						couponMatch.setMatchStatus(matchResume.getMatchStatus());
						couponMatch.setScoreHomeTeam(matchResume.getHomeTeamMatch().getScore());
						couponMatch.setScoreAwayTeam(matchResume.getAwayTeamMatch().getScore());
						if(matchResume.getHomeTeamMatch().getScore() > matchResume.getAwayTeamMatch().getScore()){
							couponMatch.setWinnerTeam(couponMatch.getHomeTeam());
						}else if(matchResume.getHomeTeamMatch().getScore() < matchResume.getAwayTeamMatch().getScore()){
							couponMatch.setWinnerTeam(couponMatch.getAwayTeam());
						}//EMPATE vai NULL
						
						couponMatch.setUpdatedDate(new Date());
						couponMatchRepository.update(couponMatch);

					}
				}
			}
		}
		
		LOG.info(String.format("%n=== finished read and update matches [%s] in [%s] ===", date, dateFormat.format(new Date())));
	}
}

