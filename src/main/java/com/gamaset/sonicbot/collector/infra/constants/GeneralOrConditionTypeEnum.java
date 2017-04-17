package com.gamaset.sonicbot.collector.infra.constants;

import java.util.Arrays;

public enum GeneralOrConditionTypeEnum {

	GENERAL(1L), CONDITION(2L);
	
	private Long id;

	private GeneralOrConditionTypeEnum(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public static GeneralOrConditionTypeEnum findById(Long id) {
		return Arrays.asList(values()).stream().filter(t -> t.getId().equals(id)).findAny()
        		.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", id)));
	}
}
