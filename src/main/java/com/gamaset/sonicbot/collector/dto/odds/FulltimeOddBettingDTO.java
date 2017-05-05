package com.gamaset.sonicbot.collector.dto.odds;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
public class FulltimeOddBettingDTO {

	@JsonProperty("1")
	private List<Bet365OddsBettingDTO> homeWinOdd;
	@JsonProperty(value = "2")
	private List<Bet365OddsBettingDTO> drawOdd;
	@JsonProperty("3")
	private List<Bet365OddsBettingDTO> awayWinOdd;
	
	public List<Bet365OddsBettingDTO> getHomeWinOdd() {
		return homeWinOdd;
	}

	public void setHomeWinOdd(List<Bet365OddsBettingDTO> homeWinOdd) {
		this.homeWinOdd = homeWinOdd;
	}

	public List<Bet365OddsBettingDTO> getDrawOdd() {
		return drawOdd;
	}

	public void setDrawOdd(List<Bet365OddsBettingDTO> drawOdd) {
		this.drawOdd = drawOdd;
	}

	public List<Bet365OddsBettingDTO> getAwayWinOdd() {
		return awayWinOdd;
	}

	public void setAwayWinOdd(List<Bet365OddsBettingDTO> awayWinOdd) {
		this.awayWinOdd = awayWinOdd;
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
