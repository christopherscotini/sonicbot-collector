package com.gamaset.sonicbot.collector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.business.bankroll.ManagerProcessBankroll;
import com.gamaset.sonicbot.collector.dto.BankrollDTO;
import com.gamaset.sonicbot.collector.dto.requestbody.CreatebetRequestBodyDTO;
import com.gamaset.sonicbot.collector.infra.ObjectsConverter;
import com.gamaset.sonicbot.collector.infra.constants.BetStatusEnum;
import com.gamaset.sonicbot.collector.repository.BankrollRepository;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
@Service
public class BankrollService {

	@Autowired
	private BankrollRepository bankrollRepository;
	@Autowired
	private ManagerProcessBankroll bankrollBusiness;
	
	
	public List<BankrollDTO> bankrolls() {
		return ObjectsConverter.convertListBankroll(bankrollRepository.findAll());
	}


	public BankrollDTO bankroll(Long bankrollId) {
		return ObjectsConverter.convert(bankrollRepository.findById(bankrollId));
	}


	public void addBet(CreatebetRequestBodyDTO request) {
		//@TODO: implement validation
		bankrollBusiness.updateBankroll(request);
		
	}
	
}
