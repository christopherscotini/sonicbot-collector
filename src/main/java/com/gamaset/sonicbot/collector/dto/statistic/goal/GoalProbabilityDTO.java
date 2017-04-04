package com.gamaset.sonicbot.collector.dto.statistic.goal;

import com.gamaset.sonicbot.collector.dto.statistic.StatsMarketDTO;
import com.gamaset.sonicbot.collector.infra.constants.GeneralOrConditionType;
import com.gamaset.sonicbot.collector.infra.constants.GoalCriteriaNumberMatchesType;
import com.gamaset.sonicbot.collector.infra.constants.GoalMarketType;
import com.gamaset.sonicbot.collector.infra.constants.GoalTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetType;

public class GoalProbabilityDTO {

	private GeneralOrConditionType generalConditionType;
	private GoalMarketType goalMarketType;
	private GoalTypeEnum goalType;
	private GoalCriteriaNumberMatchesType goalCriteriaNumberMatchesType;
	private StatsMarketDTO probability;
	
	/**
	 * @param generalConditionType
	 * @param selectionMarketBetType
	 * @param goalType
	 * @param goalCriteriaNumberMatchesType
	 */
	public GoalProbabilityDTO(GeneralOrConditionType generalConditionType,
			GoalMarketType goalMarketType, GoalTypeEnum goalType, GoalCriteriaNumberMatchesType goalCriteriaNumberMatchesType) {
		this.generalConditionType = generalConditionType;
		this.goalMarketType = goalMarketType;
		this.goalType = goalType;
		this.goalCriteriaNumberMatchesType = goalCriteriaNumberMatchesType;
		if(goalMarketType.equals(GoalMarketType.OVER_05)){
			this.probability = new StatsMarketDTO(SelectionMarketBetType.OVER_05.getId());
		}else{
			if(goalMarketType.equals(GoalMarketType.OVER_15)){
				this.probability = new StatsMarketDTO(SelectionMarketBetType.OVER_15.getId());
			}
		}
	}

	public StatsMarketDTO getProbability() {
		return probability;
	}

	public GoalMarketType getGoalMarketType() {
		return goalMarketType;
	}

	public GoalCriteriaNumberMatchesType getGoalCriteriaNumberMatchesType() {
		return goalCriteriaNumberMatchesType;
	}

	public GeneralOrConditionType getGeneralConditionType() {
		return generalConditionType;
	}

	public GoalTypeEnum getGoalType() {
		return goalType;
	}

	public GoalCriteriaNumberMatchesType getGoalCriteriaType() {
		return goalCriteriaNumberMatchesType;
	}
	
}
