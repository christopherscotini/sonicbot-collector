package com.gamaset.sonicbot.collector.dto.statistic;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TeamStatisticsDTO {

	private StatsMarketDTO fulltimeResult;
	private StatsMarketDTO doubleChanceResult;
	
	
	public StatsMarketDTO getFulltimeResult() {
		return fulltimeResult;
	}

	public void setFulltimeResult(StatsMarketDTO fulltimeResult) {
		this.fulltimeResult = fulltimeResult;
	}

	public StatsMarketDTO getDoubleChanceResult() {
		return doubleChanceResult;
	}

	public void setDoubleChanceResult(StatsMarketDTO doubleChanceResult) {
		this.doubleChanceResult = doubleChanceResult;
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
