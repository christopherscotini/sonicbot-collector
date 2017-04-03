package com.gamaset.sonicbot.collector.service.statistic.calculator;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.infra.constants.EffectSizeEnum;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;

@Component
public class EffectSizeCalculatorComponent {

	public EffectSizeEnum calculateForWin(Double value, HomeAwayConditionEnum condition) {
		if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
			if (value >= 70) {
				return EffectSizeEnum.VERY_LARGE;
			}
			if (value >= 60) {
				return EffectSizeEnum.LARGE;
			}
			if (value >= 40) {
				return EffectSizeEnum.MEDIUM;
			}
			if (value >= 30) {
				return EffectSizeEnum.LOW;
			}
			return EffectSizeEnum.NONE;
		}else{
			if (value >= 55) {
				return EffectSizeEnum.VERY_LARGE;
			}
			if (value >= 45) {
				return EffectSizeEnum.LARGE;
			}
			if (value >= 25) {
				return EffectSizeEnum.MEDIUM;
			}
			if (value >= 15) {
				return EffectSizeEnum.LOW;
			}
			return EffectSizeEnum.NONE;
		}
	}

	public EffectSizeEnum calculateForDoubleChance(Double value, HomeAwayConditionEnum condition) {
		if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
			if (value >= 90) {
				return EffectSizeEnum.VERY_LARGE;
			}
			if (value >= 80) {
				return EffectSizeEnum.LARGE;
			}
			if (value >= 70) {
				return EffectSizeEnum.MEDIUM;
			}
			if (value >= 60) {
				return EffectSizeEnum.LOW;
			}
			return EffectSizeEnum.NONE;
		}else{
			if (value >= 80) {
				return EffectSizeEnum.VERY_LARGE;
			}
			if (value >= 70) {
				return EffectSizeEnum.LARGE;
			}
			if (value >= 50) {
				return EffectSizeEnum.MEDIUM;
			}
			if (value >= 20) {
				return EffectSizeEnum.LOW;
			}
			return EffectSizeEnum.NONE;
		}
		
	}

}
