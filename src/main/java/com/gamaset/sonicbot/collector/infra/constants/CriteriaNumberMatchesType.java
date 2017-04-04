package com.gamaset.sonicbot.collector.infra.constants;

public enum CriteriaNumberMatchesType {

	ALL_GAMES(null), LAST3_MATCHES(3);
	
	private Integer numerOfMatches;
	
	private CriteriaNumberMatchesType(Integer numberOfmatches) {
		this.numerOfMatches = numberOfmatches;
	}

	public Integer getNumerOfMatches() {
		return numerOfMatches;
	}
	
}
