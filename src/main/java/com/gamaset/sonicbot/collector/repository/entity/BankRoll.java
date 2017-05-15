package com.gamaset.sonicbot.collector.repository.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "bankroll")
public class BankRoll {

	@Id
	@Column(name = "BANK_CD_ID_PK")
	private Long id;
	
	@Column(name = "BANK_DS_DATE")
	private String date;

	@Column(name = "BANK_DS_NAME")
	private String description;
	
	@Column(name = "BANK_VL_INITIAL_BANK")
	private BigDecimal initialBankrollValue;

	@Column(name = "BANK_VL_ACTUAL_BANK")
	private BigDecimal actualBankrollValue;

	@Column(name = "BANK_VL_YIELD_VALUE")
	private BigDecimal yieldValue;

	@Column(name = "BANK_VL_YIELD_PERCENTAGE")
	private BigDecimal yieldPercentage;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BANK_DT_CREATED")
	private Date createdDate;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BANK_DT_UPDATED")
	private Date updatedDate;
	
	@OneToMany(mappedBy = "bankroll")
	private List<BankRollBet> bankRollBets; 
	
	public BankRoll() {	}


//	public String getStatus(){
//		for (CouponMatch couponMatch : couponMatches) {
//			if(!couponMatch.getMatchStatus().equals(MatchStatusEnum.TERMINADO)){
//				return "Há Jogos não Finalizados.";
//			}
//		}
//		return "Jogos Finalizados.";
//	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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

	public List<BankRollBet> getBankRollBets() {
		return bankRollBets;
	}

	public void setBankRollBets(List<BankRollBet> bankRollBets) {
		this.bankRollBets = bankRollBets;
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
