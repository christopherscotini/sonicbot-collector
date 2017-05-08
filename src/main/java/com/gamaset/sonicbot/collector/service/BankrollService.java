package com.gamaset.sonicbot.collector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.repository.BankrollRepository;
import com.gamaset.sonicbot.collector.repository.entity.BetBankRoll;

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
	
	
	public List<BetBankRoll> bankrolls() {
		return bankrollRepository.findAll();
	}


	public BetBankRoll bankroll(Long bankrollId) {
		return bankrollRepository.findById(bankrollId);
	}
	
}
