package com.gamaset.sonicbot.collector.dto.statistic;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MatchStatisticDTO {

	private TeamStatisticsDTO homeTeamStats;
	private TeamStatisticsDTO awayTeamStats;

	public MatchStatisticDTO() {	}
	
	public MatchStatisticDTO(TeamStatisticsDTO homeTeamStats, TeamStatisticsDTO awayTeamStats) {
		this.homeTeamStats = homeTeamStats;
		this.awayTeamStats = awayTeamStats;
	}

	public TeamStatisticsDTO getHomeTeamStats() {
		return homeTeamStats;
	}


	public void setHomeTeamStats(TeamStatisticsDTO homeTeamStats) {
		this.homeTeamStats = homeTeamStats;
	}


	public TeamStatisticsDTO getAwayTeamStats() {
		return awayTeamStats;
	}


	public void setAwayTeamStats(TeamStatisticsDTO awayTeamStats) {
		this.awayTeamStats = awayTeamStats;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}
