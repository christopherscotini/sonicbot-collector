package com.gamaset.sonicbot.collector.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;


/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@JsonPropertyOrder({ "id", "date", "allMatchesPlayed", "matches" })
public class MatchSeriesDTO {
	
	private Long id;
	private String date;
	private List<MatchResumeDTO> matches;
	private boolean allMatchesPlayed;
	
	public boolean isAllMatchesPlayed() {
		if(matches.isEmpty()){
			return false;
		}
		
		this.allMatchesPlayed = matches.size()>0?true:false;
		for (MatchResumeDTO dto : matches) {
			if(!dto.getMatchStatus().equals(MatchStatusEnum.TERMINADO)){
				return false;
			}
		}
		return allMatchesPlayed;
	}

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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
