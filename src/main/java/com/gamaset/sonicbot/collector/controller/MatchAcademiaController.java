package com.gamaset.sonicbot.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.business.statistic.ManagerProcessMatchStatistic;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.service.academia.match.MatchAcademiaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * Controller que gerencia os endpoints para Listagem das partidas do academia das apostas
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Api(tags="MatchAcademia")
@RestController
@RequestMapping(value = "academia/matches")
public class MatchAcademiaController {

	@Autowired
	private MatchAcademiaService matchAcademiaService;
	@Autowired
	private ManagerProcessMatchStatistic managerProcessMatchStatistic;

	
	@ApiOperation(value="Retorna as partidas do dia.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = { "application/json; charset=UTF-8" })
	public MatchSeriesDTO list(
			@ApiParam(value="Usado para determinar a data dos jogos que serão lidos.", required=false) 
			@RequestParam(required = false) String date) {
		
		return matchAcademiaService.listByDate(date);
	}

	@ApiOperation(value="Retorna os detalhes da partida", notes="Busca os detalhes da partida de acordo com o id")
	@RequestMapping(method = RequestMethod.POST, value = "/detail", consumes = {"application/json; charset=UTF-8" })
	public MatchStatisticDTO detail(
			@ApiParam(value="Usado para retornar os detalhes da partida.", required=true) 
			@RequestBody MatchResumeDTO match){
		
		return managerProcessMatchStatistic.generateStatistics(match);
	}

}
