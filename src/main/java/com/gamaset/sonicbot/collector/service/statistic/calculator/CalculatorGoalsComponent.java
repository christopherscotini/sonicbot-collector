package com.gamaset.sonicbot.collector.service.statistic.calculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.GoalProbabilityDTO;
import com.gamaset.sonicbot.collector.infra.constants.GeneralOrConditionTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.CriteriaAnalisysMatchesTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalMarketTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;

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
		GoalProbabilityDTO prob1 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_05, GoalTypeEnum.SCORED, CriteriaAnalisysMatchesTypeEnum.ALL_GAMES);
		GoalProbabilityDTO prob2 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_05, GoalTypeEnum.SCORED, CriteriaAnalisysMatchesTypeEnum.LAST3_MATCHES);
		GoalProbabilityDTO prob3 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_05, GoalTypeEnum.CONCEDED, CriteriaAnalisysMatchesTypeEnum.ALL_GAMES);
		GoalProbabilityDTO prob4 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_05, GoalTypeEnum.CONCEDED, CriteriaAnalisysMatchesTypeEnum.LAST3_MATCHES);
		GoalProbabilityDTO prob5 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_15, GoalTypeEnum.SCORED, CriteriaAnalisysMatchesTypeEnum.ALL_GAMES);
		GoalProbabilityDTO prob6 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_15, GoalTypeEnum.SCORED, CriteriaAnalisysMatchesTypeEnum.LAST3_MATCHES);
		GoalProbabilityDTO prob7 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_15, GoalTypeEnum.CONCEDED, CriteriaAnalisysMatchesTypeEnum.ALL_GAMES);
		GoalProbabilityDTO prob8 = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.CONDITION, GoalMarketTypeEnum.OVER_15, GoalTypeEnum.CONCEDED, CriteriaAnalisysMatchesTypeEnum.LAST3_MATCHES);
		
		calcProbs(prob1, matches, condition);
		calcProbs(prob2, matches, condition);
		calcProbs(prob3, matches, condition);
		calcProbs(prob4, matches, condition);
		calcProbs(prob5, matches, condition);
		calcProbs(prob6, matches, condition);
		calcProbs(prob7, matches, condition);
		calcProbs(prob8, matches, condition);
		
		goalProbs.add(prob1);
		goalProbs.add(prob2);
		goalProbs.add(prob3);
		goalProbs.add(prob4);
		goalProbs.add(prob5);
		goalProbs.add(prob6);
		goalProbs.add(prob7);
		goalProbs.add(prob8);
		
		return goalProbs;
	}

	private void calcProbs(GoalProbabilityDTO prob, List<TeamMatchDetailDTO> matches, HomeAwayConditionEnum condition) {
		int occurs = 0;
		
		int numberCriteriaMatches = prob.getNumberMatchesType()==CriteriaAnalisysMatchesTypeEnum.ALL_GAMES?matches.size():prob.getNumberMatchesType().getNumerOfMatches();
		int numberMatches = matches.size()>numberCriteriaMatches?numberCriteriaMatches:matches.size();
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
		
		prob.getProbability().setValue(occurs==0?0:new Double((occurs * 100) / numberMatches));
		prob.getProbability().setSize(sizeCalculator.calculateForGoal(prob.getProbability().getValue(), condition, prob.getGoalMarketType(), prob.getGoalType()));
		
	}
	

}
