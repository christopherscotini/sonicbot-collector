package com.gamaset.sonicbot.collector.infra.constants;

import java.util.Arrays;

public enum SelectionMarketBetTypeEnum {

	OVER_05(5L),
	OVER_15(7L),
	HOME_TEAM_WIN(1L),
	AWAY_TEAM_WIN(3L),
	HOME_TEAM_OR_DRAW(21L),
	DRAW_OR_AWAY_TEAM(23L);
	
	private Long id;

	private SelectionMarketBetTypeEnum(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static SelectionMarketBetTypeEnum findById(Long id) {
		return Arrays.asList(values()).stream().filter(t -> t.getId().equals(id)).findAny()
        		.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", id)));
	}

}
