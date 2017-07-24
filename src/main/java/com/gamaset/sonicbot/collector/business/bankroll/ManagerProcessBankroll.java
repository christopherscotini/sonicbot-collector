package com.gamaset.sonicbot.collector.business.bankroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.business.bankroll.process.BetCalculator;
import com.gamaset.sonicbot.collector.business.bankroll.process.ProcessUpdateBetToBankroll;
import com.gamaset.sonicbot.collector.dto.requestbody.CreatebetRequestBodyDTO;
import com.gamaset.sonicbot.collector.infra.constants.BetStatusEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
@Component
public class ManagerProcessBankroll {
	
	@Autowired
	private ProcessUpdateBetToBankroll processUpdateBetToBankroll;
	@Autowired
	private BetCalculator betCalculator;

	public void updateBankroll(CreatebetRequestBodyDTO request) {
			
			processUpdateBetToBankroll.execute(request);
		
			if (request.getStatus().equals(BetStatusEnum.WON)) {
//				soma lucro no saldo atual
//				soma lucro no saldo de lucro
//				atualiza porc lucro 
				
			}else{
//				subtrai lucro no saldo atual
//				subtrai lucro no saldo de lucro
//				atualiza porc lucro 
			}
	}

}
