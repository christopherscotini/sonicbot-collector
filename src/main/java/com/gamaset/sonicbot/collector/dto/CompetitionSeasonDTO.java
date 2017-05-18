package com.gamaset.sonicbot.collector.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class CompetitionSeasonDTO {
	
	private Long id;
	private CompetitionDTO competition;
	private SeasonDTO season;
	
	public CompetitionSeasonDTO() {	}
	
	public CompetitionSeasonDTO(Long id, CompetitionDTO competition, SeasonDTO season) {
		this.id = id;
		this.competition = competition;
		this.season = season;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompetitionDTO getCompetition() {
		return competition;
	}
	public void setCompetition(CompetitionDTO competition) {
		this.competition = competition;
	}
	public SeasonDTO getSeason() {
		return season;
	}
	public void setSeason(SeasonDTO season) {
		this.season = season;
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
