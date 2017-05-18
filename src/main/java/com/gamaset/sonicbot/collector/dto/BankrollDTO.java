package com.gamaset.sonicbot.collector.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BankrollDTO {

	private Long id;
	private String date;
	private String description;
	private BigDecimal initialBankrollValue;
	private BigDecimal actualBankrollValue;
	private BigDecimal yieldValue;
	private BigDecimal yieldPercentage;
	private Date createdDate;
	private Date updatedDate;
	
	
	public BankrollDTO() {
	}

	/**
	 * @param id
	 * @param date
	 * @param description
	 * @param initialBankrollValue
	 * @param actualBankrollValue
	 * @param yieldValue
	 * @param yieldPercentage
	 * @param createdDate
	 * @param updatedDate
	 */
	public BankrollDTO(Long id, String date, String description, BigDecimal initialBankrollValue,
			BigDecimal actualBankrollValue, BigDecimal yieldValue, BigDecimal yieldPercentage, Date createdDate,
			Date updatedDate) {
		this.id = id;
		this.date = date;
		this.description = description;
		this.initialBankrollValue = initialBankrollValue;
		this.actualBankrollValue = actualBankrollValue;
		this.yieldValue = yieldValue;
		this.yieldPercentage = yieldPercentage;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getInitialBankrollValue() {
		return initialBankrollValue;
	}
	public void setInitialBankrollValue(BigDecimal initialBankrollValue) {
		this.initialBankrollValue = initialBankrollValue;
	}
	public BigDecimal getActualBankrollValue() {
		return actualBankrollValue;
	}
	public void setActualBankrollValue(BigDecimal actualBankrollValue) {
		this.actualBankrollValue = actualBankrollValue;
	}
	public BigDecimal getYieldValue() {
		return yieldValue;
	}
	public void setYieldValue(BigDecimal yieldValue) {
		this.yieldValue = yieldValue;
	}
	public BigDecimal getYieldPercentage() {
		return yieldPercentage;
	}
	public void setYieldPercentage(BigDecimal yieldPercentage) {
		this.yieldPercentage = yieldPercentage;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
