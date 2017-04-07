package com.gamaset.sonicbot.collector.infra.constants;

public enum GeneralOrConditionTypeEnum {

	GENERAL(1L), CONDITION(2L);
	
	private Long id;

	private GeneralOrConditionTypeEnum(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
