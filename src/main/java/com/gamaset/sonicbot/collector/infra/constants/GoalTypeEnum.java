package com.gamaset.sonicbot.collector.infra.constants;

import java.util.Arrays;

public enum GoalTypeEnum {
	
	SCORED(1L), CONCEDED(2L);

	private Long id;

	private GoalTypeEnum(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public static GoalTypeEnum findById(Long id) {
		return Arrays.asList(values()).stream().filter(t -> t.getId().equals(id)).findAny()
        		.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", id)));
	}
	
}

