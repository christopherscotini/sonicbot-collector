package com.gamaset.sonicbot.collector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.repository.entity.BetBankRoll;
import com.gamaset.sonicbot.collector.service.BankrollService;

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
	public List<BetBankRoll> list() {
		return bankrollService.bankrolls();
	}

	@ApiOperation(value="Retorna o bankroll por id.", notes="")
	@RequestMapping(method = RequestMethod.GET, value = "/{bankrollId}", produces = { "application/json; charset=UTF-8" })
	public BetBankRoll find(@PathVariable("bankrollId") Long bankrollId) {
		return bankrollService.bankroll(bankrollId);
	}

}
