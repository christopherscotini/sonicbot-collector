package com.gamaset.sonicbot.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamaset.sonicbot.collector.business.probabilitymatch.ManagerProcessProbabilityMatchSchedule;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.service.BettingOddsService;

@RestController
public class Test {

	@Autowired
	private BettingOddsService service;
	@Autowired
	private ManagerProcessProbabilityMatchSchedule probabilityMatch;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/test", produces = { "application/json; charset=UTF-8" })
	public void test(){
		String date = DateUtils.getNowDateFormatted();
//		service.getOddsByDate(date, probabilityMatch.read(date));
		service.getOddsByDate("2017-05-05", null);
		service.getOddsByDate("2017-05-06", null);
		service.getOddsByDate("2017-05-07", null);
		service.getOddsByDate("2017-05-08", null);
	}
}
