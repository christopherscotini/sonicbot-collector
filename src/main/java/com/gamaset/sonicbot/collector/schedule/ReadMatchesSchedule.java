package com.gamaset.sonicbot.collector.schedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.business.probabilitymatch.ManagerProcessProbabilityMatchSchedule;
import com.gamaset.sonicbot.collector.business.statistic.ManagerProcessMatchStatistic;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.repository.CouponMatchRepository;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.service.match.MatchService;

@Component
public class ReadMatchesSchedule {

	private final static Logger LOG = LogManager.getLogger(ReadMatchesSchedule.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	// ler as 00:01:00 
	private static final String CRON_CONFIG_UPDATE_MATCHES = "00 10 23 * * ?";
	private static final String CRON_CONFIG_STATS_MATCHES = "00 01 00 * * ?";
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
		LOG.info("=== initializing read and save matches today ===" + dateFormat.format(new Date()));
		
		MatchSeriesDTO matchSeries = matchService.listByDate(null);
		List<MatchDataDTO> datas = new ArrayList<>();
		for (MatchResumeDTO matchResume : matchSeries.getMatches()) {
			matchResume.setDate(matchSeries.getDate());
			MatchStatisticDTO matchStatisticDTO = matchStatistic.generateStatistics(matchResume);
			datas.add(new MatchDataDTO(matchResume, matchStatisticDTO));
		}
		
		probabilityMatch.save(datas);
		
		LOG.info("=== finished read and save matches today ===" + dateFormat.format(new Date()));
	}
	@Scheduled(cron = CRON_CONFIG_UPDATE_MATCHES, zone=ZONE_CONFIG)
	public void executeReadMatchesAndUpdateResults() {
		LOG.info("=== initializing read and update matches results today ===" + dateFormat.format(new Date()));
		
		MatchSeriesDTO matchSeries = matchService.listByDate(null);
		List<CouponMatch> matches = couponMatchRepository.findByCouponId(matchSeries.getId());
		for (CouponMatch couponMatch : matches) {
			//TODO atualizar somente os com status TERMINADO
			System.out.println(couponMatch);
		}
		
		LOG.info("=== finished read and update matches today ===" + dateFormat.format(new Date()));
	}
}

