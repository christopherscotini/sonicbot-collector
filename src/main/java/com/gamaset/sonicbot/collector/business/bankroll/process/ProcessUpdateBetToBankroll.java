package com.gamaset.sonicbot.collector.business.bankroll.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.requestbody.CreatebetRequestBodyDTO;
import com.gamaset.sonicbot.collector.infra.ObjectsConverter;
import com.gamaset.sonicbot.collector.repository.BankRollBetRepository;
import com.gamaset.sonicbot.collector.repository.entity.BankRollBet;

@Component
public class ProcessUpdateBetToBankroll {

	@Autowired
	private BankRollBetRepository betRepo;
	
	@Autowired
	private BetCalculator calculator;
	
	public void execute(CreatebetRequestBodyDTO request){
		if(request.getBetId() == null){
			betRepo.insert(createEntity(request));
		}
		
	}
	
	private BankRollBet createEntity(CreatebetRequestBodyDTO request){
		BankRollBet entity = new BankRollBet();
		entity.setBetDate(request.getBetDate());
		entity.setBankroll(ObjectsConverter.convert(request.getBankroll()));
		entity.setCompetition(ObjectsConverter.convert(request.getCompetition()));
		entity.setHomeTeam(ObjectsConverter.convert(request.getHomeTeam()));
		entity.setAwayTeam(ObjectsConverter.convert(request.getAwayTeam()));
		entity.setMarketBet(ObjectsConverter.convert(request.getMarketBet()));
		entity.setFinalValueBankroll(request.getBankroll().getActualBankrollValue());
		entity.setBetAmount(request.getBetAmount());
		entity.setProfit(request.getProfit());
		entity.setBetPercentualBankroll(calculator.calculateBetPercentualBankroll(entity.getFinalValueBankroll(), entity.getBetAmount()));
		entity.setProfitability(calculator.calculateProfitability(entity.getFinalValueBankroll(), entity.getProfit()));
		entity.setRoi(calculator.calculateRoi());
		entity.setStatus(request.getStatus());
		return entity;
	}
	
}
