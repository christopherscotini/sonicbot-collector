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
@Table(name = "competition")
public class Competition {
	
	@Id
	@Column(name = "COMP_CD_ID_PK")
	private Long id;
	
	@Column(name = "COMP_DS_NAME")
	private String name;

	@Column(name = "COMP_DS_URL")
	private String url;
	
	@Column(name = "COBE_CD_ID_FK")
	private Integer compIdbetOdd;
	
	@ManyToOne
	@JoinColumn(name = "FLAG_CD_ID_FK")
	private Flag flag;
	
	@ManyToOne
	@JoinColumn(name = "COUN_CD_ID_FK")
	private Country country;
	

	public Competition() {}
	
	public Competition(Long id, String name, String url, Flag flag, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.flag = flag;
		this.country = country;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	/**
	 * @return the compIdbetOdd
	 */
	public Integer getCompIdbetOdd() {
		return compIdbetOdd;
	}

	/**
	 * @param compIdbetOdd the compIdbetOdd to set
	 */
	public void setCompIdbetOdd(Integer compIdbetOdd) {
		this.compIdbetOdd = compIdbetOdd;
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
