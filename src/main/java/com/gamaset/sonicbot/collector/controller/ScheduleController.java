package com.gamaset.sonicbot.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.schedule.ReadMatchesSchedule;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	public void runToday(){
		readMatchesSchedule.executeReadMatchesAndPersist();
	}

	/**
	 * 
	 */
	@ApiOperation(value="Atualiza as informações dos jogos de ontem", notes="")
	@RequestMapping(method = RequestMethod.POST, value = "/updateMatchesYesterday", consumes = {"application/json; charset=UTF-8" })
	public void updateToday(){
		readMatchesSchedule.executeReadMatchesAndUpdateResults();
	}
	
}
