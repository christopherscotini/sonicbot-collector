package com.gamaset.sonicbot.collector.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SelectionMarketBetDTO {

	private Long id;
	private String name;
	private MarketBetDTO marketBet;

	public SelectionMarketBetDTO() {
	}

	/**
	 * @param id
	 * @param name
	 * @param marketBet
	 */
	public SelectionMarketBetDTO(Long id, String name, MarketBetDTO marketBet) {
		this.id = id;
		this.name = name;
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

	public MarketBetDTO getMarketBet() {
		return marketBet;
	}

	public void setMarketBet(MarketBetDTO marketBet) {
		this.marketBet = marketBet;
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
