package com.gamaset.sonicbot.collector.dto.statistic;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.dto.statistic.goal.GoalProbabilityDTO;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class TeamStatisticsDTO {

	private StatsMarketDTO fulltimeProbability;
	private StatsMarketDTO doubleChanceProbability;
	private List<GoalProbabilityDTO> goalsProbability;

	public StatsMarketDTO getFulltimeProbability() {
		return fulltimeProbability;
	}

	public void setFulltimeProbability(StatsMarketDTO fulltimeProbability) {
		this.fulltimeProbability = fulltimeProbability;
	}

	public StatsMarketDTO getDoubleChanceProbability() {
		return doubleChanceProbability;
	}

	public void setDoubleChanceProbability(StatsMarketDTO doubleChanceProbability) {
		this.doubleChanceProbability = doubleChanceProbability;
	}

	public List<GoalProbabilityDTO> getGoalsProbability() {
		return goalsProbability;
	}

	public void setGoalsProbability(List<GoalProbabilityDTO> goalsProbability) {
		this.goalsProbability = goalsProbability;
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
