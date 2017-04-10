package com.gamaset.sonicbot.collector.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;

@JsonPropertyOrder("matchResume, matchstatistics")
public class MatchDataDTO {
	
	private MatchResumeDTO matchResume;
	private MatchStatisticDTO matchstatistics;
	
	public MatchDataDTO() {
	}
	
	/**
	 * @param matchResume
	 * @param matchstatistics
	 */
	public MatchDataDTO(MatchResumeDTO matchResume, MatchStatisticDTO matchstatistics) {
		this.matchResume = matchResume;
		this.matchstatistics = matchstatistics;
	}

	/**
	 * @return the matchResume
	 */
	public MatchResumeDTO getMatchResume() {
		return matchResume;
	}
	/**
	 * @param matchResume the matchResume to set
	 */
	public void setMatchResume(MatchResumeDTO matchResume) {
		this.matchResume = matchResume;
	}
	/**
	 * @return the matchstatistics
	 */
	public MatchStatisticDTO getMatchstatistics() {
		return matchstatistics;
	}
	/**
	 * @param matchstatistics the matchstatistics to set
	 */
	public void setMatchstatistics(MatchStatisticDTO matchstatistics) {
		this.matchstatistics = matchstatistics;
	}

	
}
