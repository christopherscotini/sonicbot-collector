package com.gamaset.sonicbot.collector.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TeamDTO {

	private Long id;
	private Long bettingTeamId;
	private String name;
	
	public TeamDTO() {
	}

	/**
	 * @param id
	 * @param name
	 */
	public TeamDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @param id
	 * @param bettingTeamId
	 * @param name
	 */
	public TeamDTO(Long id, Long bettingTeamId, String name) {
		super();
		this.id = id;
		this.bettingTeamId = bettingTeamId;
		this.name = name;
	}

	public Long getBettingTeamId() {
		return bettingTeamId;
	}

	public void setBettingTeamId(Long bettingTeamId) {
		this.bettingTeamId = bettingTeamId;
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
