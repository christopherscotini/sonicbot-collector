package com.gamaset.sonicbot.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.business.probabilitymatch.ManagerProcessProbabilityMatchSchedule;
import com.gamaset.sonicbot.collector.business.statistic.ManagerProcessMatchStatistic;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.schedule.ReadMatchesSchedule;
import com.gamaset.sonicbot.collector.service.match.MatchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * Controller que gerencia os endpoints para Listagem das partidas
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Api(tags="Schedule")
@RestController
@RequestMapping(value = "schedules")
public class ScheduleController {


	@Autowired
	private ReadMatchesSchedule readMatchesSchedule;
	
	/**
	 * 
	 */
	@ApiOperation(value="Insere as informações dos jogos do dia", notes="")
	@RequestMapping(method = RequestMethod.POST, value = "/runToday", consumes = {"application/json; charset=UTF-8" })
	public void test(){
		readMatchesSchedule.readMatchesAndStatsAfterPersistDatabase();
	}
	
}
