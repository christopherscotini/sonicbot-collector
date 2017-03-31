package com.gamaset.sonicbot.collector.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@JsonPropertyOrder({"matchId", "linkMatch", 
	"matchStatus", "competitionSeason", 
	"homeTeamMatch", "awayTeamMatch"})
public class MatchResumeDTO {
	
	private Long matchId;
	private String linkMatch;
	private MatchStatusEnum matchStatus;
	private CompetitionSeasonDTO competitionSeason;
	private TeamMatchDTO homeTeamMatch;
	private TeamMatchDTO awayTeamMatch;
	
	
	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	public String getLinkMatch() {
		return linkMatch;
	}

	public void setLinkMatch(String linkMatch) {
		this.linkMatch = linkMatch;
	}

	public MatchStatusEnum getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(MatchStatusEnum matchStatus) {
		this.matchStatus = matchStatus;
	}

	public TeamMatchDTO getHomeTeamMatch() {
		return homeTeamMatch;
	}

	public void setHomeTeamMatch(TeamMatchDTO homeTeamMatch) {
		this.homeTeamMatch = homeTeamMatch;
	}

	public TeamMatchDTO getAwayTeamMatch() {
		return awayTeamMatch;
	}

	public void setAwayTeamMatch(TeamMatchDTO awayTeamMatch) {
		this.awayTeamMatch = awayTeamMatch;
	}

	public CompetitionSeasonDTO getCompetitionSeason() {
		return competitionSeason;
	}

	public void setCompetitionSeason(CompetitionSeasonDTO competitionSeason) {
		this.competitionSeason = competitionSeason;
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
