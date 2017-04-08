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
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.infra.constants.EffectSizeEnum;
import com.gamaset.sonicbot.collector.repository.entity.domain.GoalType;
import com.gamaset.sonicbot.collector.repository.entity.domain.TypeCriteriaAnalisysMatch;
import com.gamaset.sonicbot.collector.repository.entity.domain.TypeGeneralCondition;

@Entity
@Table(name = "coupon_match_team_market_value")
public class CouponMatchTeamMarketValue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CMTMV_CD_ID_PK")
	private Long id;
	
	@Column(name = "CMTMV_VL_PROBABILITY")
	private Double value;

	@Enumerated(EnumType.STRING)
	@Column(name = "CMTMV_VL_SIZE")
	private EffectSizeEnum size;
	
	@ManyToOne
	@JoinColumn(name = "CMTM_CD_ID_FK")
	private CouponMatchTeamMarket couponMatchTeamMarket;
	
	@ManyToOne
	@JoinColumn(name = "GOTY_CD_ID_FK")
	private GoalType goalType;
	
	@ManyToOne
	@JoinColumn(name = "TCAM_CD_ID_FK")
	private TypeCriteriaAnalisysMatch typeCriteriaAnalisysMatch;
	
	@ManyToOne
	@JoinColumn(name = "TYGC_CD_ID_FK")
	private TypeGeneralCondition typeGeneralCondition;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public EffectSizeEnum getSize() {
		return size;
	}

	public void setSize(EffectSizeEnum size) {
		this.size = size;
	}

	public CouponMatchTeamMarket getCouponMatchTeamMarket() {
		return couponMatchTeamMarket;
	}

	public void setCouponMatchTeamMarket(CouponMatchTeamMarket couponMatchTeamMarket) {
		this.couponMatchTeamMarket = couponMatchTeamMarket;
	}

	public GoalType getGoalType() {
		return goalType;
	}

	public void setGoalType(GoalType goalType) {
		this.goalType = goalType;
	}

	public TypeCriteriaAnalisysMatch getTypeCriteriaAnalisysMatch() {
		return typeCriteriaAnalisysMatch;
	}

	public void setTypeCriteriaAnalisysMatch(TypeCriteriaAnalisysMatch typeCriteriaAnalisysMatch) {
		this.typeCriteriaAnalisysMatch = typeCriteriaAnalisysMatch;
	}

	public TypeGeneralCondition getTypeGeneralCondition() {
		return typeGeneralCondition;
	}

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
