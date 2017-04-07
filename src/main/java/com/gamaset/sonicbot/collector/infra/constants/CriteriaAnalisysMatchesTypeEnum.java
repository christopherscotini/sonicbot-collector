package com.gamaset.sonicbot.collector.infra.constants;

public enum CriteriaAnalisysMatchesTypeEnum {

	ALL_GAMES(1), LAST3_MATCHES(3);
	
	private Integer numerOfMatches;
	
	private CriteriaAnalisysMatchesTypeEnum(Integer numberOfmatches) {
		this.numerOfMatches = numberOfmatches;
	}

	public Integer getNumerOfMatches() {
		return numerOfMatches;
	}
	
}
