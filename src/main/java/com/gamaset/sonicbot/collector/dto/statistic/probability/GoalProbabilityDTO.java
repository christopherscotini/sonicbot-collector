package com.gamaset.sonicbot.collector.dto.statistic.probability;

import com.gamaset.sonicbot.collector.infra.constants.GeneralOrConditionTypeEnum;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.infra.constants.CriteriaAnalisysMatchesTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalMarketTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetTypeEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class GoalProbabilityDTO {

	private GeneralOrConditionTypeEnum generalConditionType;
	private GoalMarketTypeEnum goalMarketType;
	private GoalTypeEnum goalType;
	private CriteriaAnalisysMatchesTypeEnum numberMatchesType;
	private StatsMarketDTO probability;

	/**
	 * 
	 * @param generalConditionType
	 * @param goalMarketType
	 * @param goalType
	 * @param criteriaNumberMatchesType
	 */
	public GoalProbabilityDTO(GeneralOrConditionTypeEnum generalConditionType, GoalMarketTypeEnum goalMarketType,
			GoalTypeEnum goalType, CriteriaAnalisysMatchesTypeEnum numberMatchesType) {
		this.generalConditionType = generalConditionType;
		this.goalMarketType = goalMarketType;
		this.goalType = goalType;
		this.numberMatchesType = numberMatchesType;
		if (goalMarketType.equals(GoalMarketTypeEnum.OVER_05)) {
			this.probability = new StatsMarketDTO(SelectionMarketBetTypeEnum.OVER_05.getId());
		} else {
			if (goalMarketType.equals(GoalMarketTypeEnum.OVER_15)) {
				this.probability = new StatsMarketDTO(SelectionMarketBetTypeEnum.OVER_15.getId());
			}
		}
	}

	public StatsMarketDTO getProbability() {
		return probability;
	}

	public GoalMarketTypeEnum getGoalMarketType() {
		return goalMarketType;
	}

	public GeneralOrConditionTypeEnum getGeneralConditionType() {
		return generalConditionType;
	}

	public GoalTypeEnum getGoalType() {
		return goalType;
	}
	
	/**
	 * @return the numberMatchesType
	 */
	public CriteriaAnalisysMatchesTypeEnum getNumberMatchesType() {
		return numberMatchesType;
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
