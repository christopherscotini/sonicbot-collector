package com.gamaset.sonicbot.collector.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.repository.entity.domain.Team;

@Entity
@Table(name = "team_competition_season")
public class TeamCompetitionSeason {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TECS_CD_ID_PK")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "COSE_CD_ID_FK")
	private CompetitionSeason competitionSeason;
	@ManyToOne
	@JoinColumn(name = "TEAM_CD_ID_FK")
	private Team team;
	
	@Column(name = "TECS_BL_ACTIVE")
	private boolean active;
	
	public TeamCompetitionSeason() {	}

	public TeamCompetitionSeason(Team team, CompetitionSeason competitionSeason) {
		this.competitionSeason = competitionSeason;
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public CompetitionSeason getCompetitionSeason() {
		return competitionSeason;
	}

	public void setCompetitionSeason(CompetitionSeason competitionSeason) {
		this.competitionSeason = competitionSeason;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
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
