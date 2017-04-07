package com.gamaset.sonicbot.collector.infra.constants;

public enum GoalTypeEnum {
	
	SCORED(1L), CONCEDED(2L);

	private Long id;

	private GoalTypeEnum(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
}

