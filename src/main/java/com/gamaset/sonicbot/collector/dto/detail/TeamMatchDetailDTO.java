package com.gamaset.sonicbot.collector.dto.detail;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gamaset.sonicbot.collector.dto.TeamMatchDTO;

public class TeamMatchDetailDTO {

	private TeamMatchDTO homeTeamMatch;
	private TeamMatchDTO awayTeamMatch;
	
	@JsonIgnore
	public TeamMatchDTO getWinner(){
		if(this.homeTeamMatch.getScore() > this.awayTeamMatch.getScore()){
			return homeTeamMatch;
		}else{
			if(this.homeTeamMatch.getScore() < this.awayTeamMatch.getScore()){
				return awayTeamMatch;
			}
		}
		return null;
	}
	
	public TeamMatchDTO getHomeTeamMatch() {
		return homeTeamMatch;
	}
	public void setHomeTeamMatch(TeamMatchDTO homeTeamMatch) {
		this.homeTeamMatch = homeTeamMatch;
	}
	public TeamMatchDTO getAwayTeamMatch() {
		return awayTeamMatch;
	}
	public void setAwayTeamMatch(TeamMatchDTO awayTeamMatch) {
		this.awayTeamMatch = awayTeamMatch;
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
