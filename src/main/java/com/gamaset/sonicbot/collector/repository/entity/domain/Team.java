package com.gamaset.sonicbot.collector.repository.entity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@Column(name = "TEAM_CD_ID_PK")
	private Long id;

	@Column(name = "TEBE_CD_ID_FK")
	private Long bettingTeamId;
	
	@Column(name = "TEAM_DS_NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "COUN_CD_ID_FK")
	private Country country;
	
	public Team() {	}


	/**
	 * @param id
	 * @param bettingTeamId
	 * @param name
	 * @param country
	 */
	public Team(Long id, Long bettingTeamId, String name, Country country) {
		super();
		this.id = id;
		this.bettingTeamId = bettingTeamId;
		this.name = name;
		this.country = country;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
