package com.gamaset.sonicbot.collector.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "coupon_match_team")
public class CouponMatchTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COMT_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COMA_CD_ID_FK")
	private CouponMatch couponMatch;

	@ManyToOne
	@JoinColumn(name = "TECS_CD_ID_FK")
	private TeamCompetitionSeason teamCompetitionSeason;
	
	@OneToMany(mappedBy = "couponMatchTeam")
	private List<CouponMatchTeamProbValue> couponMatchTeamProbValues;
	
	
	/**
	 * @return the couponMatchTeamProbValues
	 */
	public List<CouponMatchTeamProbValue> getCouponMatchTeamProbValues() {
		return couponMatchTeamProbValues;
	}

	/**
	 * @param couponMatchTeamProbValues the couponMatchTeamProbValues to set
	 */
	public void setCouponMatchTeamProbValues(List<CouponMatchTeamProbValue> couponMatchTeamProbValues) {
		this.couponMatchTeamProbValues = couponMatchTeamProbValues;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CouponMatch getCouponMatch() {
		return couponMatch;
	}

	public void setCouponMatch(CouponMatch couponMatch) {
		this.couponMatch = couponMatch;
	}

	public TeamCompetitionSeason getTeamCompetitionSeason() {
		return teamCompetitionSeason;
	}

	public void setTeamCompetitionSeason(TeamCompetitionSeason teamCompetitionSeason) {
		this.teamCompetitionSeason = teamCompetitionSeason;
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
