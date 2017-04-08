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

import com.gamaset.sonicbot.collector.repository.entity.domain.SelectionMarketBet;

@Entity
@Table(name = "coupon_match_team_market")
public class CouponMatchTeamMarket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CMTM_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "SEMB_CD_ID_FK")
	private SelectionMarketBet selectionMarketBet;

	@ManyToOne
	@JoinColumn(name = "COMT_CD_ID_FK")
	private CouponMatchTeam couponMatchTeam;
	
//	@OneToMany(mappedBy = "predictionProbabilityDetail")
//	private List<PredictionProbabilityDetailItem> predictionProbabilityDetailItems;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SelectionMarketBet getSelectionMarketBet() {
		return selectionMarketBet;
	}

	public void setSelectionMarketBet(SelectionMarketBet selectionMarketBet) {
		this.selectionMarketBet = selectionMarketBet;
	}


	public CouponMatchTeam getCouponMatchTeam() {
		return couponMatchTeam;
	}

	public void setCouponMatchTeam(CouponMatchTeam couponMatchTeam) {
		this.couponMatchTeam = couponMatchTeam;
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
