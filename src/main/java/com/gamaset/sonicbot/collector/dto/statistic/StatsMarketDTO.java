package com.gamaset.sonicbot.collector.dto.statistic;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.infra.constants.EffectSizeEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class StatsMarketDTO {

	private Long selectionMarketBetId;
	private Double value;
	private EffectSizeEnum size;

	public StatsMarketDTO() {}
	
	/**
	 * @param selectionMarketBetId
	 */
	public StatsMarketDTO(Long selectionMarketBetId) {
		this.selectionMarketBetId = selectionMarketBetId;
	}


	public Long getSelectionMarketBetId() {
		return selectionMarketBetId;
	}

	public void setSelectionMarketBetId(Long selectionMarketBetId) {
		this.selectionMarketBetId = selectionMarketBetId;
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
