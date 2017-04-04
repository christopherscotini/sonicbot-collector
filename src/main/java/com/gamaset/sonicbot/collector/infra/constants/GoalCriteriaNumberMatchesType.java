package com.gamaset.sonicbot.collector.infra.constants;

public enum GoalCriteriaNumberMatchesType {

	ALL_GAMES(null), LAST3_MATCHES(3);
	
	private Integer numerOfMatches;
	
	private GoalCriteriaNumberMatchesType(Integer numberOfmatches) {
		this.numerOfMatches = numberOfmatches;
	}

	public Integer getNumerOfMatches() {
		return numerOfMatches;
	}
	
}
