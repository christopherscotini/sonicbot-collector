package com.gamaset.sonicbot.collector.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.service.match.MatchService;

@Component
public class ReadMatchesSchedule {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private static final String CRON_CONFIG = "0 55 01 * * ?";
	private static final String ZONE_CONFIG = "America/Sao_Paulo";
	
	@Autowired
	private MatchService matchService;
	
	@Scheduled(cron = CRON_CONFIG, zone=ZONE_CONFIG)
	public void readMatchesAndStatsAfterPersistDatabase() {
		System.out.println("before Job ran at " + dateFormat.format(new Date()));
		MatchSeriesDTO matchsOfTheDay = matchService.listByDate(null);
		
		System.out.println("readMatchesAndStatsAfterPersistDatabase Job ran at " + dateFormat.format(new Date()));
	}
}
