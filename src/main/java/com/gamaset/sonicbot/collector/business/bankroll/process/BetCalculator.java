package com.gamaset.sonicbot.collector.business.bankroll.process;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.infra.utils.CalculatorUtils;

@Component
public class BetCalculator {

	private CalculatorUtils calculator;
	
	/**
	 * Calcula a rentabilidade da aposta sendo (lucro/valorFinalBanca)
	 * @param finalValueBankroll
	 * @param profit
	 * @return
	 */
	public BigDecimal calculateProfitability(BigDecimal finalValueBankroll, BigDecimal profit) {
		return calculator.divide(profit, finalValueBankroll);
	}

	public BigDecimal calculateRoi() {
		return null;
	}

	public BigDecimal calculateProfit() {
		return null;
	}

	/**
	 * Calcula a porcentagem do valor apostado em relação ao valor de banca
	 * 
	 * @param finalValueBankroll
	 * @param betAmount
	 * @return
	 */
	public BigDecimal calculateBetPercentualBankroll(BigDecimal finalValueBankroll, BigDecimal betAmount){
		return calculator.divide(betAmount, finalValueBankroll);
	}
	
}
