package com.gamaset.sonicbot.collector.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TeamCompetitionSeasonDTO {
	
	private Long id;
	private CompetitionSeasonDTO competitionSeason;
	private TeamDTO team;
	private boolean active;
	
	public TeamCompetitionSeasonDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param competitionSeason
	 * @param team
	 * @param active
	 */
	public TeamCompetitionSeasonDTO(Long id, CompetitionSeasonDTO competitionSeason, TeamDTO team, boolean active) {
		super();
		this.id = id;
		this.competitionSeason = competitionSeason;
		this.team = team;
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CompetitionSeasonDTO getCompetitionSeason() {
		return competitionSeason;
	}
	public void setCompetitionSeason(CompetitionSeasonDTO competitionSeason) {
		this.competitionSeason = competitionSeason;
	}
	public TeamDTO getTeam() {
		return team;
	}
	public void setTeam(TeamDTO team) {
		this.team = team;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
