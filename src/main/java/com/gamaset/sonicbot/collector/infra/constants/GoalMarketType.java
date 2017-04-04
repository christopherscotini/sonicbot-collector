package com.gamaset.sonicbot.collector.infra.constants;

public enum GoalMarketType {

	OVER_05(0), OVER_15(1);
	
	private Integer numberGoals;
	
	private GoalMarketType(Integer numberGoals) {
		this.numberGoals = numberGoals;
	}

	public Integer getNumberGoals() {
		return numberGoals;
	}
	
}
