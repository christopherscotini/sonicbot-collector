package com.gamaset.sonicbot.collector.dto.detail;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MatchDetailDTO {
	
	private MatchDetailTeamDTO matchDetailHomeTeam;
	private MatchDetailTeamDTO matchDetailAwayTeam;
	
	public MatchDetailTeamDTO getMatchDetailHomeTeam() {
		return matchDetailHomeTeam;
	}
	public void setMatchDetailHomeTeam(MatchDetailTeamDTO matchDetailHomeTeam) {
		this.matchDetailHomeTeam = matchDetailHomeTeam;
	}
	public MatchDetailTeamDTO getMatchDetailAwayTeam() {
		return matchDetailAwayTeam;
	}
	public void setMatchDetailAwayTeam(MatchDetailTeamDTO matchDetailAwayTeam) {
		this.matchDetailAwayTeam = matchDetailAwayTeam;
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
