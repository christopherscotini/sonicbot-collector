package com.gamaset.sonicbot.collector.repository.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.dto.MatchStatusEnum;

@Entity
@Table(name = "coupon_match")
public class CouponMatch {

	@Id
	@Column(name = "COMA_CD_ID_PK")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "COUP_CD_ID_FK")
	private Coupon coupon;

	@ManyToOne
	@JoinColumn(name = "TECS_HOME_CD_ID_FK")
	private TeamCompetitionSeason homeTeam;

	@ManyToOne
	@JoinColumn(name = "TECS_AWAY_CD_ID_FK")
	private TeamCompetitionSeason awayTeam;
	
	@ManyToOne
	@JoinColumn(name = "TECS_WINNER_CD_ID_FK")
	private TeamCompetitionSeason winnerTeam;

	@Column(name = "COMA_VL_POS_HOME")
	private Integer posHomeTeam;

	@Column(name = "COMA_VL_POS_AWAY")
	private Integer posAwayTeam;

	@Column(name = "COMA_VL_SCORE_HOME")
	private Integer scoreHomeTeam;

	@Column(name = "COMA_VL_SCORE_AWAY")
	private Integer scoreAwayTeam;

	@Column(name = "COMA_DS_URL_MATCH")
	private String urlMatch;

	@Column(name = "COMA_DS_MATCH_DATE")
	private String matchDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "COMA_DS_MATCH_STATUS")
	private MatchStatusEnum matchStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMA_DT_CREATED")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMA_DT_UPDATED")
	private Date updatedDate;

	@OneToMany(mappedBy = "couponMatch")
	private List<CouponMatchTeam> couponMatchTeams;

	public void setWinnerTeam(TeamCompetitionSeason winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	/**
	 * @return the couponMatchTeam
	 */
	public List<CouponMatchTeam> getCouponMatchTeams() {
		return couponMatchTeams;
	}

	/**
	 * @param couponMatchTeam the couponMatchTeam to set
	 */
	public void setCouponMatchTeams(List<CouponMatchTeam> couponMatchTeams) {
		this.couponMatchTeams = couponMatchTeams;
	}

	/**
	 * @return the matchDate
	 */
	public String getMatchDate() {
		return matchDate;
	}

	/**
	 * @param matchDate the matchDate to set
	 */
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getPosHomeTeam() {
		return posHomeTeam;
	}

	public void setPosHomeTeam(Integer posHomeTeam) {
		this.posHomeTeam = posHomeTeam;
	}

	public Integer getPosAwayTeam() {
		return posAwayTeam;
	}

	public void setPosAwayTeam(Integer posAwayTeam) {
		this.posAwayTeam = posAwayTeam;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
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

	public Integer getScoreHomeTeam() {
		return scoreHomeTeam;
	}

	public void setScoreHomeTeam(Integer scoreHomeTeam) {
		this.scoreHomeTeam = scoreHomeTeam;
	}

	public Integer getScoreAwayTeam() {
		return scoreAwayTeam;
	}

	public void setScoreAwayTeam(Integer scoreAwayTeam) {
		this.scoreAwayTeam = scoreAwayTeam;
	}

	public String getUrlMatch() {
		return urlMatch;
	}

	public void setUrlMatch(String urlMatch) {
		this.urlMatch = urlMatch;
	}

	public TeamCompetitionSeason getWinnerTeam() {
		Objects.requireNonNull(scoreHomeTeam, "[scoreHomeTeam] field cannot be null.");
		Objects.requireNonNull(scoreAwayTeam, "[scoreAwayTeam] field cannot be null.");

		if (this.scoreHomeTeam > this.scoreAwayTeam) {
			return homeTeam;
		} else {
			if (this.scoreHomeTeam < this.scoreAwayTeam) {
				return awayTeam;
			}
		}

		return null;
	}

	/**
	 * @return the matchStatus
	 */
	public MatchStatusEnum getMatchStatus() {
		return matchStatus;
	}

	/**
	 * @param matchStatus
	 *            the matchStatus to set
	 */
	public void setMatchStatus(MatchStatusEnum matchStatus) {
		this.matchStatus = matchStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
