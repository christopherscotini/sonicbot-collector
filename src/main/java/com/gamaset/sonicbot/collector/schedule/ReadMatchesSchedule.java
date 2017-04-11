package com.gamaset.sonicbot.collector.schedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.business.probabilitymatch.ManagerProcessProbabilityMatchSchedule;
import com.gamaset.sonicbot.collector.business.statistic.ManagerProcessMatchStatistic;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.service.match.MatchService;

@Component
public class ReadMatchesSchedule {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	// ler as 00:01:00 
	private static final String CRON_CONFIG = "00 01 00 * * ?";
	private static final String ZONE_CONFIG = "America/Sao_Paulo";
	
	@Autowired
	private MatchService matchService;
	@Autowired
	private ManagerProcessMatchStatistic matchStatistic;
	@Autowired
	private ManagerProcessProbabilityMatchSchedule probabilityMatch;
	
	@Scheduled(cron = CRON_CONFIG, zone=ZONE_CONFIG)
	public void readMatchesAndStatsAfterPersistDatabase() {
		System.out.println("before Job ran at " + dateFormat.format(new Date()));
		
		MatchSeriesDTO matchSeries = matchService.listByDate(null);
		List<MatchDataDTO> datas = new ArrayList<>();
		for (MatchResumeDTO matchResume : matchSeries.getMatches()) {
			matchResume.setDate(matchSeries.getDate());
			MatchStatisticDTO matchStatisticDTO = matchStatistic.generateStatistics(matchResume);
			datas.add(new MatchDataDTO(matchResume, matchStatisticDTO));
		}
		
		probabilityMatch.save(datas);
		
		System.out.println("after Job ran at " + dateFormat.format(new Date()));
	}
}

