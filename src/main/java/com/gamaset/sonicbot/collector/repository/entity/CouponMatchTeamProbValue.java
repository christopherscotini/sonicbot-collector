package com.gamaset.sonicbot.collector.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.infra.constants.EffectSizeEnum;
import com.gamaset.sonicbot.collector.repository.entity.domain.SelectionMarketBet;
import com.gamaset.sonicbot.collector.repository.entity.domain.TypeCriteriaAnalisysMatch;
import com.gamaset.sonicbot.collector.repository.entity.domain.TypeGeneralCondition;

@Entity
@Table(name = "coupon_match_team_prob_value")
public class CouponMatchTeamProbValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CMTPV_CD_ID_PK")
	private Long id;
	
	@Column(name = "CMTPV_VL_PROBABILITY")
	private Double value;

	@Enumerated(EnumType.STRING)
	@Column(name = "CMTPV_VL_SIZE")
	private EffectSizeEnum size;
	
	@ManyToOne
	@JoinColumn(name = "SEMB_CD_ID_FK")
	private SelectionMarketBet selectionMarketBet;

	@ManyToOne
	@JoinColumn(name = "COMT_CD_ID_FK")
	private CouponMatchTeam couponMatchTeam;
	
	@ManyToOne
	@JoinColumn(name = "TCAM_CD_ID_FK")
	private TypeCriteriaAnalisysMatch typeCriteriaAnalisysMatch;
	
	@ManyToOne
	@JoinColumn(name = "TYGC_CD_ID_FK")
	private TypeGeneralCondition typeGeneralCondition;
	
	@OneToOne(mappedBy = "couponMatchTeamProbValue")
	private CouponMatchTeamProbValueGoal couponMatchTeamProbValueGoal;
	

	public CouponMatchTeamProbValueGoal getCouponMatchTeamProbValueGoal() {
		return couponMatchTeamProbValueGoal;
	}

	public void setCouponMatchTeamProbValueGoal(CouponMatchTeamProbValueGoal couponMatchTeamProbValueGoal) {
		this.couponMatchTeamProbValueGoal = couponMatchTeamProbValueGoal;
	}

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
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @return the size
	 */
	public EffectSizeEnum getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(EffectSizeEnum size) {
		this.size = size;
	}

	/**
	 * @return the selectionMarketBet
	 */
	public SelectionMarketBet getSelectionMarketBet() {
		return selectionMarketBet;
	}

	/**
	 * @param selectionMarketBet the selectionMarketBet to set
	 */
	public void setSelectionMarketBet(SelectionMarketBet selectionMarketBet) {
		this.selectionMarketBet = selectionMarketBet;
	}

	/**
	 * @return the couponMatchTeam
	 */
	public CouponMatchTeam getCouponMatchTeam() {
		return couponMatchTeam;
	}

	/**
	 * @param couponMatchTeam the couponMatchTeam to set
	 */
	public void setCouponMatchTeam(CouponMatchTeam couponMatchTeam) {
		this.couponMatchTeam = couponMatchTeam;
	}

	/**
	 * @return the typeCriteriaAnalisysMatch
	 */
	public TypeCriteriaAnalisysMatch getTypeCriteriaAnalisysMatch() {
		return typeCriteriaAnalisysMatch;
	}

	/**
	 * @param typeCriteriaAnalisysMatch the typeCriteriaAnalisysMatch to set
	 */
	public void setTypeCriteriaAnalisysMatch(TypeCriteriaAnalisysMatch typeCriteriaAnalisysMatch) {
		this.typeCriteriaAnalisysMatch = typeCriteriaAnalisysMatch;
	}

	/**
	 * @return the typeGeneralCondition
	 */
	public TypeGeneralCondition getTypeGeneralCondition() {
		return typeGeneralCondition;
	}

	/**
	 * @param typeGeneralCondition the typeGeneralCondition to set
	 */
	public void setTypeGeneralCondition(TypeGeneralCondition typeGeneralCondition) {
		this.typeGeneralCondition = typeGeneralCondition;
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
