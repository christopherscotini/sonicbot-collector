package com.gamaset.sonicbot.collector.dto.odds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamaset.sonicbot.collector.dto.CompetitionDTO;
import com.gamaset.sonicbot.collector.dto.TeamDTO;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
@JsonIgnoreProperties({"datetime", "odds"})
public class EventBettingDTO {
	
	@JsonProperty(value="id")
	private String id;
	@JsonProperty(value="home")
	private TeamDTO home;
	@JsonProperty(value="away")
	private TeamDTO away;
	@JsonProperty(value="league")
	private CompetitionDTO league;
	private SportBettingDTO sport;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TeamDTO getHome() {
		return home;
	}

	public void setHome(TeamDTO home) {
		this.home = home;
	}

	public TeamDTO getAway() {
		return away;
	}

	public void setAway(TeamDTO away) {
		this.away = away;
	}

	public CompetitionDTO getLeague() {
		return league;
	}

	public void setLeague(CompetitionDTO league) {
		this.league = league;
	}

	public SportBettingDTO getSport() {
		return sport;
	}

	public void setSport(SportBettingDTO sport) {
		this.sport = sport;
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
