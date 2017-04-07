package com.gamaset.sonicbot.collector.infra.constants;

public enum PositionConditionEnum {
	GENERAL(0), HOME(1), AWAY(2);
	
	private Integer numberCondition;
	
	private PositionConditionEnum(Integer numberCondition) {
		this.numberCondition = numberCondition;
	}

	public Integer getNumberCondition() {
		return numberCondition;
	}
	
	
}
