package com.gamaset.sonicbot.collector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;
import com.gamaset.sonicbot.collector.service.team.TeamCompetitionSeasonService;

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
@Api(tags="TeamCompetitionSeason")
@RestController
@RequestMapping(value = "tcs")
public class TeamCompetitionSeasonController {


	@Autowired
	private TeamCompetitionSeasonService teamCompetitionSeasonService;
	
	/**
	 * 
	 */
	@ApiOperation(value="Lista os Times por Competição/Sessão", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = { "application/json; charset=UTF-8" })
	public List<TeamCompetitionSeason> list(){
		return teamCompetitionSeasonService.list();
	}

}
