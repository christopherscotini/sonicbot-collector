package com.gamaset.sonicbot.collector.infra.utils;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public enum HomeAwayConditionEnum {

	
	HOME_TEAM("a"), AWAY_TEAM("b");
	
	private String codeTeamString;

	/**
	 * @param getStringCodeTeam
	 */
	private HomeAwayConditionEnum(String codeTeamString) {
		this.codeTeamString = codeTeamString;
	}

	public String getConditionCodeString() {
		return codeTeamString;
	}

}