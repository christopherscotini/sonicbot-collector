package com.gamaset.sonicbot.collector.dto.odds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OddBettingDTO {

	@JsonProperty("1")
	public FulltimeOddBettingDTO fulltimeOdd;
	@JsonProperty("3")
	public DoubleChanceOddBettingDTO doubleChanceOdd;
	
	public FulltimeOddBettingDTO getFulltimeOdd() {
		return fulltimeOdd;
	}

	public void setFulltimeOdd(FulltimeOddBettingDTO fulltimeOdd) {
		this.fulltimeOdd = fulltimeOdd;
	}
	
	public DoubleChanceOddBettingDTO getDoubleChanceOdd() {
		return doubleChanceOdd;
	}

	public void setDoubleChanceOdd(DoubleChanceOddBettingDTO doubleChanceOdd) {
		this.doubleChanceOdd = doubleChanceOdd;
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
