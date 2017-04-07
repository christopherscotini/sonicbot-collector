package com.gamaset.sonicbot.collector.repository.entity.domain;

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

@Entity
@Table(name = "selection_market_bet")
public class SelectionMarketBet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SEMB_CD_ID_PK")
	private Long id;
	
	@Column(name = "SEMB_DS_NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "MABE_CD_ID_FK")
	private MarketBet marketBet;
	
	public SelectionMarketBet() {	}

	public SelectionMarketBet(Long id, String name, MarketBet marketBet) {
		this.id = id;
		this.name = name;
		this.marketBet = marketBet;
	}


	public MarketBet getMarketBet() {
		return marketBet;
	}


	public void setMarketBet(MarketBet marketBet) {
		this.marketBet = marketBet;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
