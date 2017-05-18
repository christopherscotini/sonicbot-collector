package com.gamaset.sonicbot.collector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.dto.CompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.service.CompetitionService;

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
@Api(tags="CompetitionSeason")
@RestController
@RequestMapping(value = "competition-seasons")
public class CompetitionSeasonController {

	@Autowired
	private CompetitionService competitionService;

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value="Retorna todos os campeonatos/sessões cadastrados.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = { "application/json; charset=UTF-8" })
	public List<CompetitionSeasonDTO> list() {
		return competitionService.competitionSeasons();
	}

}
