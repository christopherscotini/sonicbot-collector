package com.gamaset.sonicbot.collector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.repository.BankrollRepository;
import com.gamaset.sonicbot.collector.repository.entity.BankRoll;

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
	
	
	public List<BankRoll> bankrolls() {
		return bankrollRepository.findAll();
	}


	public BankRoll bankroll(Long bankrollId) {
		return bankrollRepository.findById(bankrollId);
	}
	
}
