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

import com.gamaset.sonicbot.collector.repository.entity.domain.GoalType;

@Entity
@Table(name = "coupon_match_team_prob_value_goal")
public class CouponMatchTeamProbValueGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CMTPVG_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CMTPV_CD_ID_FK")
	private CouponMatchTeamProbValue couponMatchTeamProbValue;

	@ManyToOne
	@JoinColumn(name = "GOTY_CD_ID_FK")
	private GoalType goalType;
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the couponMatchTeamProbValue
	 */
	public CouponMatchTeamProbValue getCouponMatchTeamProbValue() {
		return couponMatchTeamProbValue;
	}

	/**
	 * @param couponMatchTeamProbValue the couponMatchTeamProbValue to set
	 */
	public void setCouponMatchTeamProbValue(CouponMatchTeamProbValue couponMatchTeamProbValue) {
		this.couponMatchTeamProbValue = couponMatchTeamProbValue;
	}

	/**
	 * @return the goalType
	 */
	public GoalType getGoalType() {
		return goalType;
	}

	/**
	 * @param goalType the goalType to set
	 */
	public void setGoalType(GoalType goalType) {
		this.goalType = goalType;
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
