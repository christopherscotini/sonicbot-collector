package com.gamaset.sonicbot.collector.service.statistic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.goal.GoalProbabilityDTO;
import com.gamaset.sonicbot.collector.infra.constants.GeneralOrConditionType;
import com.gamaset.sonicbot.collector.infra.constants.GoalCriteriaNumberMatchesType;
import com.gamaset.sonicbot.collector.infra.constants.GoalMarketType;
import com.gamaset.sonicbot.collector.infra.constants.GoalTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.service.statistic.calculator.EffectSizeCalculatorComponent;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class CalculatorGoalsComponent {

	@Autowired
	private EffectSizeCalculatorComponent sizeCalculator;
	
	//VIRAR LISTA
	public List<GoalProbabilityDTO> calculate(List<TeamMatchDetailDTO> matches, HomeAwayConditionEnum condition) {
		List<GoalProbabilityDTO> goalProbs = new ArrayList<GoalProbabilityDTO>();
		//CONDITIONAL
		GoalProbabilityDTO prob1 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_05, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.ALL_GAMES);
		GoalProbabilityDTO prob2 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_05, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
		GoalProbabilityDTO prob3 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_05, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.ALL_GAMES);
		GoalProbabilityDTO prob4 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_05, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
		GoalProbabilityDTO prob5 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_15, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.ALL_GAMES);
		GoalProbabilityDTO prob6 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_15, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
		GoalProbabilityDTO prob7 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_15, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.ALL_GAMES);
		GoalProbabilityDTO prob8 = new GoalProbabilityDTO(GeneralOrConditionType.CONDITION, GoalMarketType.OVER_15, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
		
		//GENERAL
//		GoalProbabilityDTO prob10 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_05, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.ALL_GAMES);
//		GoalProbabilityDTO prob20 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_05, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
//		GoalProbabilityDTO prob30 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_05, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.ALL_GAMES);
//		GoalProbabilityDTO prob40 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_05, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
//		GoalProbabilityDTO prob50 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_15, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.ALL_GAMES);
//		GoalProbabilityDTO prob60 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_15, GoalTypeEnum.SCORED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
//		GoalProbabilityDTO prob70 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_15, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.ALL_GAMES);
//		GoalProbabilityDTO prob80 = new GoalProbabilityDTO(GeneralOrConditionType.GENERAL, GoalMarketType.OVER_15, GoalTypeEnum.CONCEDED, GoalCriteriaNumberMatchesType.LAST3_MATCHES);
		
		calcProbs(prob1, matches, condition);
		calcProbs(prob2, matches, condition);
		calcProbs(prob3, matches, condition);
		calcProbs(prob4, matches, condition);
		calcProbs(prob5, matches, condition);
		calcProbs(prob6, matches, condition);
		calcProbs(prob7, matches, condition);
		calcProbs(prob8, matches, condition);
//		calcProbs(prob10, matches, condition);
//		calcProbs(prob20, matches, condition);
//		calcProbs(prob30, matches, condition);
//		calcProbs(prob40, matches, condition);
//		calcProbs(prob50, matches, condition);
//		calcProbs(prob60, matches, condition);
//		calcProbs(prob70, matches, condition);
//		calcProbs(prob80, matches, condition);
		
		goalProbs.add(prob1);
		goalProbs.add(prob2);
		goalProbs.add(prob3);
		goalProbs.add(prob4);
		goalProbs.add(prob5);
		goalProbs.add(prob6);
		goalProbs.add(prob7);
		goalProbs.add(prob8);
//		goalProbs.add(prob10);
//		goalProbs.add(prob20);
//		goalProbs.add(prob30);
//		goalProbs.add(prob40);
//		goalProbs.add(prob50);
//		goalProbs.add(prob60);
//		goalProbs.add(prob70);
//		goalProbs.add(prob80);
		
		return goalProbs;
	}

	private void calcProbs(GoalProbabilityDTO prob, List<TeamMatchDetailDTO> matches, HomeAwayConditionEnum condition) {
		int occurs = 0;
		
		int numberMatches = prob.getGoalCriteriaType()==GoalCriteriaNumberMatchesType.ALL_GAMES?matches.size():prob.getGoalCriteriaType().getNumerOfMatches();
		for (int i = 0; i < numberMatches; i++) {
			TeamMatchDetailDTO match = matches.get(i);
			
			if(condition.equals(HomeAwayConditionEnum.HOME_TEAM)){
				if(prob.getGoalType().equals(GoalTypeEnum.SCORED)){
					if(match.getHomeTeamMatch().getScore() > prob.getGoalMarketType().getNumberGoals()){
						occurs++;
					}
				}else{
					if(match.getAwayTeamMatch().getScore() > prob.getGoalMarketType().getNumberGoals()){
						occurs++;
					}
				}
			}else{
				if(prob.getGoalType().equals(GoalTypeEnum.SCORED)){
					if(match.getAwayTeamMatch().getScore() > prob.getGoalMarketType().getNumberGoals()){
						occurs++;
					}
				}else{
					if(match.getHomeTeamMatch().getScore() > prob.getGoalMarketType().getNumberGoals()){
						occurs++;
					}
				}
			}
		}
		
		
		prob.getProbability().setValue(new Double((occurs * 100) / numberMatches));
		prob.getProbability().setSize(sizeCalculator.calculateForGoal(prob.getProbability().getValue(), condition, prob.getGoalType(), prob.getGoalMarketType()));
		
	}
	

}
