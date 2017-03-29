package com.gamaset.sonicbot.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.service.match.MatchDetailService;
import com.gamaset.sonicbot.collector.service.match.MatchService;

/**
 * 
 * Controller que gerencia os endpoints para Listagem das partidas
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping( value = "match")
public class MatchController {

	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchDetailService matchDetailService;
	
	
	/**
	 * @return 
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = {"application/json; charset=UTF-8" })
	public MatchSeriesDTO list(){
		
		
		return matchService.listByDate();
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/detail/{matchId}", produces = {"application/json; charset=UTF-8" })
	public void detail(){
		
		
		matchDetailService.detail();
		
	}
	
}
