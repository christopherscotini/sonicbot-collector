package com.gamaset.sonicbot.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.service.BettingOddsService;

@RestController
public class Test {

	@Autowired
	private BettingOddsService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/test", produces = { "application/json; charset=UTF-8" })
	public void test(){
		service.getOddsByDate(DateUtils.getNowDateFormatted());
	}
}
