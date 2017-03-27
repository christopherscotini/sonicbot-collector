package com.gamaset.sonicbot.collector.dto;

import java.util.List;

import com.gamaset.sonicbot.collector.infra.utils.DateUtils;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class MatchSeriesDTO {
	
	private Long id;
	private String date;
	private List<MatchResumeDTO> matches;

	public Long getId() {
		if(!(date == null || date.isEmpty())){
			return DateUtils.convertDateStringToDate(this.date).getTime();
		}
		return id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<MatchResumeDTO> getMatches() {
		return matches;
	}
	public void setMatches(List<MatchResumeDTO> matches) {
		this.matches = matches;
	}

}
