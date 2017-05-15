package com.gamaset.sonicbot.collector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.dto.requestbody.CreatebetRequestBodyDTO;
import com.gamaset.sonicbot.collector.repository.entity.BankRoll;
import com.gamaset.sonicbot.collector.service.BankrollService;

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
@Api(tags="Bankroll")
@RestController
@RequestMapping(value = "bankrolls")
public class BankrollController {

	@Autowired
	private BankrollService bankrollService;

	/**
	 * 
	 * @return
	 */
	@ApiOperation(value="Retorna todos os bankrolls cadastrados.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = { "application/json; charset=UTF-8" })
	public List<BankRoll> list() {
		return bankrollService.bankrolls();
	}

	@ApiOperation(value="Retorna o bankroll por id.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/{bankrollId}", produces = { "application/json; charset=UTF-8" })
	public BankRoll find(@PathVariable("bankrollId") Long bankrollId) {
		return bankrollService.bankroll(bankrollId);
	}

	@ApiOperation(value="Cria a bet no respectivo bankroll.", notes="")
	@RequestMapping(method = RequestMethod.POST, value = "/{bankrollId}/bets", consumes = { "application/json; charset=UTF-8" })
	public void createBet(@PathVariable("bankrollId") Long bankrollId,
			@RequestBody CreatebetRequestBodyDTO bet) {
		
		System.out.println(">>"+bet.toString());
	}

}
