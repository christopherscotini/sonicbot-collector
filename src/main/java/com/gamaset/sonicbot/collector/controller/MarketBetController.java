package com.gamaset.sonicbot.collector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.repository.entity.domain.SelectionMarketBet;
import com.gamaset.sonicbot.collector.service.market.SelectionMarketBetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * Controller que gerencia os endpoints para Listagem das partidas
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
@Api(tags="MarketBet")
@RestController
@RequestMapping(value = "markets")
public class MarketBetController {

	@Autowired
	private SelectionMarketBetService selectionMarketBetService;

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value="Retorna todos os mercados cadastrados.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = { "application/json; charset=UTF-8" })
	public List<SelectionMarketBet> list() {
		return selectionMarketBetService.markets();
	}


}
