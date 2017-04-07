package com.gamaset.sonicbot.collector.dto.statistic;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.dto.PositionDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.DoubleChanceProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.FulltimeProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.GoalProbabilityDTO;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class TeamStatisticsDTO {

	private List<FulltimeProbabilityDTO> fulltimeProbabilities;
	private List<DoubleChanceProbabilityDTO> doubleChanceProbabilities;
	private List<GoalProbabilityDTO> goalsProbabilities;
	private List<PositionDTO> positions;

	/**
	 * @return the fulltimeProbabilities
	 */
	public List<FulltimeProbabilityDTO> getFulltimeProbabilities() {
		return fulltimeProbabilities;
	}

	/**
	 * @param fulltimeProbabilities the fulltimeProbabilities to set
	 */
	public void setFulltimeProbabilities(List<FulltimeProbabilityDTO> fulltimeProbabilities) {
		this.fulltimeProbabilities = fulltimeProbabilities;
	}

	/**
	 * @return the doubleChanceProbabilities
	 */
	public List<DoubleChanceProbabilityDTO> getDoubleChanceProbabilities() {
		return doubleChanceProbabilities;
	}

	/**
	 * @param doubleChanceProbabilities the doubleChanceProbabilities to set
	 */
	public void setDoubleChanceProbabilities(List<DoubleChanceProbabilityDTO> doubleChanceProbabilities) {
		this.doubleChanceProbabilities = doubleChanceProbabilities;
	}

	/**
	 * @return the goalsProbabilities
	 */
	public List<GoalProbabilityDTO> getGoalsProbabilities() {
		return goalsProbabilities;
	}

	/**
	 * @param goalsProbabilities the goalsProbabilities to set
	 */
	public void setGoalsProbabilities(List<GoalProbabilityDTO> goalsProbabilities) {
		this.goalsProbabilities = goalsProbabilities;
	}

	public List<PositionDTO> getPositions() {
		return positions;
	}

	public void setPositions(List<PositionDTO> positions) {
		this.positions = positions;
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
