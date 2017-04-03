package com.gamaset.sonicbot.collector.infra.constants;

public enum SelectionMarketBetConstants {

	HOME_TEAM_WIN(1L),
	AWAY_TEAM_WIN(3L),
	OVER_05(5L),
	OVER_15(7L),
	HOME_TEAM_OR_DRAW(21L),
	DRAW_OR_AWAY_TEAM(23L);
	
	private Long id;

	private SelectionMarketBetConstants(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
