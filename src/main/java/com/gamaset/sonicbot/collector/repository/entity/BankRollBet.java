package com.gamaset.sonicbot.collector.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.infra.constants.BetStatusEnum;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;
import com.gamaset.sonicbot.collector.repository.entity.domain.SelectionMarketBet;

@Entity
@Table(name = "bet_bankroll")
public class BankRollBet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "BET_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "BANK_CD_ID_FK")
	private BankRoll bankroll;

	@ManyToOne
	@JoinColumn(name = "COMP_CD_ID_FK")
	private Competition competition;

	@ManyToOne
	@JoinColumn(name = "TEAS_CD_ID_FK_HOME")
	private TeamCompetitionSeason homeTeam;
	
	@ManyToOne
	@JoinColumn(name = "TEAS_CD_ID_FK_AWAY")
	private TeamCompetitionSeason awayTeam;
	
	@ManyToOne
	@JoinColumn(name = "SEMB_CD_ID_FK")
	private SelectionMarketBet marketBet;

	@Column(name = "BEBA_VL_BET_AMOUNT")
	private BigDecimal betAmount;

	@Column(name = "BEBA_VL_PERC_BET_BEBA_ROLL")
	private BigDecimal betPercentualBankroll;
	
	@Column(name = "BEBA_VL_PRFIT")
	private BigDecimal profit;
	
	@Column(name = "BEBA_VL_PERC_ROI")
	private BigDecimal roi;
	
	@Column(name = "BEBA_VL_PERC_PROFITABILITY")
	private BigDecimal profitability;

	@Column(name = "BEBA_VL_FINAL_BANKROLL")
	private BigDecimal finalValueBankroll;

	@Enumerated(EnumType.STRING)
	@Column(name = "BEBA_DS_STATUS")
	private BetStatusEnum status;
	
	public BankRollBet() {
		// TODO Auto-generated constructor stub
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public BankRoll getBankroll() {
		return bankroll;
	}

	public void setBankroll(BankRoll bankroll) {
		this.bankroll = bankroll;
	}

	public BetStatusEnum getStatus() {
		return status;
	}

	public void setStatus(BetStatusEnum status) {
		this.status = status;
	}

	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	public TeamCompetitionSeason getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(TeamCompetitionSeason homeTeam) {
		this.homeTeam = homeTeam;
	}
	public TeamCompetitionSeason getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(TeamCompetitionSeason awayTeam) {
		this.awayTeam = awayTeam;
	}
	public SelectionMarketBet getMarketBet() {
		return marketBet;
	}
	public void setMarketBet(SelectionMarketBet marketBet) {
		this.marketBet = marketBet;
	}
	public BigDecimal getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}
	public BigDecimal getBetPercentualBankroll() {
		return betPercentualBankroll;
	}
	public void setBetPercentualBankroll(BigDecimal betPercentualBankroll) {
		this.betPercentualBankroll = betPercentualBankroll;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public BigDecimal getRoi() {
		return roi;
	}
	public void setRoi(BigDecimal roi) {
		this.roi = roi;
	}
	public BigDecimal getProfitability() {
		return profitability;
	}
	public void setProfitability(BigDecimal profitability) {
		this.profitability = profitability;
	}
	public BigDecimal getFinalValueBankroll() {
		return finalValueBankroll;
	}
	public void setFinalValueBankroll(BigDecimal finalValueBankroll) {
		this.finalValueBankroll = finalValueBankroll;
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
