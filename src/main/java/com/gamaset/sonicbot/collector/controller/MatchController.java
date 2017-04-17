package com.gamaset.sonicbot.collector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.repository.entity.Coupon;
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
@RequestMapping(value = "matches")
public class MatchController {

	@Autowired
	private MatchService matchService;

	
	@ApiOperation(value="Retorna todos os dias lidos.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/coupons", produces = { "application/json; charset=UTF-8" })
	public List<Coupon> listCoupons() {
		
		return matchService.coupons();
	}

	@ApiOperation(value="Retorna as partidas do dia.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = { "application/json; charset=UTF-8" })
	public List<MatchDataDTO> list(
			@ApiParam(value="Usado para determinar a data dos jogos que serão lidos.", required=false) 
			@RequestParam(required = false) String date) {
		
		return matchService.listByDate(date);
	}

	@ApiOperation(value="Retorna os detalhes da partida", notes="Busca os detalhes da partida de acordo com o id")
	@RequestMapping(method = RequestMethod.POST, value = "/detail", consumes = {"application/json; charset=UTF-8" })
	public MatchStatisticDTO detail(
			@ApiParam(value="Usado para retornar os detalhes da partida.", required=true) 
			@RequestBody MatchResumeDTO match){
		
		return null;
	}

}
