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
public class DoubleChanceOddBettingDTO {

	
	@JsonProperty("6")
	private List<Bet365OddsBettingDTO> homeDrawOdd;
	@JsonProperty(value = "7")
	private List<Bet365OddsBettingDTO> homeAwayOdd;
	@JsonProperty("8")
	private List<Bet365OddsBettingDTO> awayDrawOdd;

	public List<Bet365OddsBettingDTO> getHomeDrawOdd() {
		return homeDrawOdd;
	}

	public void setHomeDrawOdd(List<Bet365OddsBettingDTO> homeDrawOdd) {
		this.homeDrawOdd = homeDrawOdd;
	}

	public List<Bet365OddsBettingDTO> getHomeAwayOdd() {
		return homeAwayOdd;
	}

	public void setHomeAwayOdd(List<Bet365OddsBettingDTO> homeAwayOdd) {
		this.homeAwayOdd = homeAwayOdd;
	}

	public List<Bet365OddsBettingDTO> getAwayDrawOdd() {
		return awayDrawOdd;
	}

	public void setAwayDrawOdd(List<Bet365OddsBettingDTO> awayDrawOdd) {
		this.awayDrawOdd = awayDrawOdd;
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
