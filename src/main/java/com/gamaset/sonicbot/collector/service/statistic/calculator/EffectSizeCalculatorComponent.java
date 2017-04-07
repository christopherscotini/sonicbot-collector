package com.gamaset.sonicbot.collector.service.statistic.calculator;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.infra.constants.EffectSizeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalMarketTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class EffectSizeCalculatorComponent {

	public EffectSizeEnum calculateForWin(Double value, HomeAwayConditionEnum condition) {
		if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
			return calc(70, 60, 40, 30, value);
		}else{
			return calc(55, 45, 25, 15, value);
		}
	}

	public EffectSizeEnum calculateForDoubleChance(Double value, HomeAwayConditionEnum condition) {
		if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
			return calc(90, 80, 70, 60, value);
		}else{
			return calc(80, 70, 50, 20, value);
		}
		
	}

	public EffectSizeEnum calculateForGoal(Double value, HomeAwayConditionEnum condition, GoalMarketTypeEnum goalMarketType, GoalTypeEnum goalType) {
		if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
			if(goalMarketType.equals(GoalMarketTypeEnum.OVER_05)){
				if(goalType.equals(GoalTypeEnum.SCORED)){
					return calc(90, 80, 70, 60, value);
				}else{
					return calc(80, 70, 60, 50, value);
				}
			}else if(goalMarketType.equals(GoalMarketTypeEnum.OVER_15)){
				if(goalType.equals(GoalTypeEnum.SCORED)){
					return calc(70, 60, 40, 30, value);
				}else{
					return calc(40, 30, 20, 10, value);
				}
			}
		}else{
			if(goalMarketType.equals(GoalMarketTypeEnum.OVER_05)){
				if(goalType.equals(GoalTypeEnum.SCORED)){
					return calc(90, 80, 60, 50, value);
				}else{
					return calc(90, 80, 70, 60, value);
				}
			}else if(goalMarketType.equals(GoalMarketTypeEnum.OVER_15)){
				if(goalType.equals(GoalTypeEnum.SCORED)){
					return calc(50, 40, 20, 10, value);
				}else{
					return calc(60, 50, 40, 30, value);
				}
			}
		}
		
		return null;
	}
	
	private EffectSizeEnum calc(Integer veryLarge, Integer large, Integer medium, Integer low, Double value){
		if (value >= veryLarge) {
			return EffectSizeEnum.VERY_LARGE;
		}
		if (value >= large) {
			return EffectSizeEnum.LARGE;
		}
		if (value >= medium) {
			return EffectSizeEnum.MEDIUM;
		}
		if (value >= low) {
			return EffectSizeEnum.LOW;
		}
		return EffectSizeEnum.NONE;
	}

}
