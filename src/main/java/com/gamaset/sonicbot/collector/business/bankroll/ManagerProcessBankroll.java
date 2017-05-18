package com.gamaset.sonicbot.collector.business.bankroll;

import org.springframework.stereotype.Component;

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

	public void updateBankroll(CreatebetRequestBodyDTO request) {
		
		
		if (!request.getStatus().equals(BetStatusEnum.IN_PLAY)) {
			
		} else {
			if (request.getStatus().equals(BetStatusEnum.WON)) {
				//process win
			}else{
				//process lost
			}
		}
	}

}
