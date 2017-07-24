package com.gamaset.sonicbot.collector.dto.requestbody;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.dto.BankrollDTO;
import com.gamaset.sonicbot.collector.dto.CompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.dto.SelectionMarketBetDTO;
import com.gamaset.sonicbot.collector.dto.TeamCompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.infra.constants.BetStatusEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
public class CreatebetRequestBodyDTO {

	private Long betId;
	private String betDate;
	private BankrollDTO bankroll;
	private CompetitionSeasonDTO competition;
	private TeamCompetitionSeasonDTO homeTeam;
	private TeamCompetitionSeasonDTO awayTeam;
	private SelectionMarketBetDTO marketBet;
	private BigDecimal betAmount;
	private BigDecimal betPercentualBankroll;
	private BigDecimal profit;
	private BigDecimal roi;
	private BigDecimal profitability;
	private BigDecimal finalValueBankroll;
	private BetStatusEnum status;
	
	
	public Long getBetId() {
		return betId;
	}

	public void setBetId(Long betId) {
		this.betId = betId;
	}

	public BankrollDTO getBankroll() {
		return bankroll;
	}

	public void setBankroll(BankrollDTO bankroll) {
		this.bankroll = bankroll;
	}

	public CompetitionSeasonDTO getCompetition() {
		return competition;
	}

	public void setCompetition(CompetitionSeasonDTO competition) {
		this.competition = competition;
	}

	public TeamCompetitionSeasonDTO getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamCompetitionSeasonDTO homeTeam) {
		this.homeTeam = homeTeam;
	}

	public TeamCompetitionSeasonDTO getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(TeamCompetitionSeasonDTO awayTeam) {
		this.awayTeam = awayTeam;
	}

	public SelectionMarketBetDTO getMarketBet() {
		return marketBet;
	}

	public void setMarketBet(SelectionMarketBetDTO marketBet) {
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

	public BetStatusEnum getStatus() {
		return status;
	}

	public void setStatus(BetStatusEnum status) {
		this.status = status;
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

	/**
	 * @return the betDate
	 */
	public String getBetDate() {
		return betDate;
	}

	/**
	 * @param betDate the betDate to set
	 */
	public void setBetDate(String betDate) {
		this.betDate = betDate;
	}
}
