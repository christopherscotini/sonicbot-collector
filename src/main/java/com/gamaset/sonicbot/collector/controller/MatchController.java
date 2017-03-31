package com.gamaset.sonicbot.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.service.match.MatchDetailService;
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
@Api(tags="Match")
@RestController
@RequestMapping(value = "match")
public class MatchController {

	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchDetailService matchDetailService;

	/**
	 * @return
	 * 
	 */
	@ApiOperation(value="Retorna as partidas do dia.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = { "application/json; charset=UTF-8" })
	public MatchSeriesDTO list(@RequestParam(required = false) String date) {

		return matchService.listByDate(date);

	}

	@ApiOperation(value="Retorna os detalhes da partida", notes="Busca os detalhes da partida de acordo com o id")
	@RequestMapping(method = RequestMethod.GET, value = "/detail", produces = {"application/json; charset=UTF-8" })
	public void detail(
			@ApiParam(value="Usado para retornar os detalhes da partida.", required=true) 
			@RequestBody(required = true) MatchResumeDTO match){
		
		matchDetailService.detail(match);
		
	}

}
