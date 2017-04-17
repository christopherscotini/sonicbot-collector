package com.gamaset.sonicbot.collector.infra.constants;

import java.util.Arrays;

public enum CriteriaAnalisysMatchesTypeEnum {

	ALL_GAMES(1), LAST3_MATCHES(3);
	
	private Integer numerOfMatches;
	
	private CriteriaAnalisysMatchesTypeEnum(Integer numberOfmatches) {
		this.numerOfMatches = numberOfmatches;
	}

	public Integer getNumerOfMatches() {
		return numerOfMatches;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static CriteriaAnalisysMatchesTypeEnum findById(Long id) {
        return Arrays.asList(values()).stream().filter(t -> t.getNumerOfMatches().equals(id.intValue())).findAny()
        		.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", id)));
	}
	
}
