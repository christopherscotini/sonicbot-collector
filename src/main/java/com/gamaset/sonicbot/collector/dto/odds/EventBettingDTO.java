package com.gamaset.sonicbot.collector.dto.odds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gamaset.sonicbot.collector.dto.CompetitionDTO;
import com.gamaset.sonicbot.collector.dto.TeamDTO;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
@JsonIgnoreProperties({"datetime"})
public class EventBettingDTO {
	
	private String id;
	private TeamDTO home;
	private TeamDTO away;
	private CompetitionDTO league;
	private SportBettingDTO sport;
	private OddBettingDTO odds;
	
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

	public OddBettingDTO getOdds() {
		return odds;
	}

	public void setOdds(OddBettingDTO odds) {
		this.odds = odds;
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
