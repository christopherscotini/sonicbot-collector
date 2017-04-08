package com.gamaset.sonicbot.collector.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "coupon_match")
public class CouponMatch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COMA_CD_ID_PK")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COMA_CD_ID_FK")
	private Coupon coupon;

	@ManyToOne
	@JoinColumn(name = "TECS_HOME_CD_ID_FK")
	private TeamCompetitionSeason homeTeam;

	@ManyToOne
	@JoinColumn(name = "TECS_AWAY_CD_ID_FK")
	private TeamCompetitionSeason awayTeam;

	@Column(name = "PRDE_VL_POS_HOME")
	private Integer posHomeTeam;

	@Column(name = "PRDE_VL_POS_AWAY")
	private Integer posAwayTeam;

	@Column(name = "PRDE_VL_SCORE_HOME")
	private Integer scoreHomeTeam;
	
	@Column(name = "PRDE_VL_SCORE_AWAY")
	private Integer scoreAwayTeam;
	
	@Column(name = "PRDE_DS_URL_MATCH")
	private String urlMatch;
	
	@ManyToOne
	@JoinColumn(name = "TECS_WINNER_CD_ID_FK")
	private TeamCompetitionSeason winnerTeam;
	
//	@OneToMany(mappedBy = "teamCompetitionSeason")
//	private List<PredictionProbability> predictionProbabilities;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return winnerTeam;
	}

	public void setWinnerTeam(TeamCompetitionSeason winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

//	public List<PredictionProbability> getPredictionProbabilities() {
//		return predictionProbabilities;
//	}
//
//	public void setPredictionProbabilities(List<PredictionProbability> predictionProbabilities) {
//		this.predictionProbabilities = predictionProbabilities;
//	}

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