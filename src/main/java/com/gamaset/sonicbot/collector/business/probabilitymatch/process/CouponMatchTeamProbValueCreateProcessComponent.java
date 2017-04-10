package com.gamaset.sonicbot.collector.business.probabilitymatch.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.DoubleChanceProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.FulltimeProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.GoalProbabilityDTO;
import com.gamaset.sonicbot.collector.infra.constants.GeneralOrConditionTypeEnum;
import com.gamaset.sonicbot.collector.repository.CouponMatchTeamProbValueGoalRepository;
import com.gamaset.sonicbot.collector.repository.CouponMatchTeamProbValueRepository;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeam;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeamProbValue;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeamProbValueGoal;
import com.gamaset.sonicbot.collector.repository.entity.domain.GoalType;
import com.gamaset.sonicbot.collector.repository.entity.domain.SelectionMarketBet;
import com.gamaset.sonicbot.collector.repository.entity.domain.TypeCriteriaAnalisysMatch;
import com.gamaset.sonicbot.collector.repository.entity.domain.TypeGeneralCondition;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class CouponMatchTeamProbValueCreateProcessComponent {

	@Autowired
	private CouponMatchTeamProbValueRepository couponMatchTeamProbValueRepository;
	@Autowired
	private CouponMatchTeamProbValueGoalRepository couponMatchTeamProbValueGoalRepository;
	
	/**
	 * 
	 * @param couponMatchTeam
	 * @param teamStatistics
	 */
	public void process(CouponMatchTeam couponMatchTeam, TeamStatisticsDTO teamStatistics){
		
		doubleChanceProcess(couponMatchTeam, teamStatistics.getDoubleChanceProbabilities());
		fulltimeResultProcess(couponMatchTeam, teamStatistics.getFulltimeProbabilities());
		goalProcess(couponMatchTeam, teamStatistics.getGoalsProbabilities());
	}

	private void goalProcess(CouponMatchTeam couponMatchTeam, List<GoalProbabilityDTO> goalValues) {
		for (GoalProbabilityDTO goal : goalValues) {
			CouponMatchTeamProbValue couponMatchValue = new CouponMatchTeamProbValue();
			couponMatchValue.setCouponMatchTeam(couponMatchTeam);
			couponMatchValue.setSelectionMarketBet(new SelectionMarketBet(goal.getProbability().getSelectionMarketBetId(), null, null));
			couponMatchValue.setValue(goal.getProbability().getValue());
			couponMatchValue.setSize(goal.getProbability().getSize());
			couponMatchValue.setTypeCriteriaAnalisysMatch(new TypeCriteriaAnalisysMatch(goal.getNumberMatchesType().getNumerOfMatches().longValue(), null));
			couponMatchValue.setTypeGeneralCondition(new TypeGeneralCondition(goal.getGeneralConditionType().getId(), null));
			couponMatchValue = couponMatchTeamProbValueRepository.insert(couponMatchValue);

			CouponMatchTeamProbValueGoal entity = new CouponMatchTeamProbValueGoal();
			entity.setCouponMatchTeamProbValue(couponMatchValue);
			entity.setGoalType(new GoalType(goal.getGoalType().getId(), null));
			couponMatchTeamProbValueGoalRepository.insert(entity);
		}
	}

	private void fulltimeResultProcess(CouponMatchTeam couponMatchTeam, List<FulltimeProbabilityDTO> ftValues) {
		for (FulltimeProbabilityDTO ft : ftValues) {
			CouponMatchTeamProbValue entity = new CouponMatchTeamProbValue();
			entity.setCouponMatchTeam(couponMatchTeam);
			entity.setSelectionMarketBet(new SelectionMarketBet(ft.getStats().getSelectionMarketBetId(), null, null));
			entity.setValue(ft.getStats().getValue());
			entity.setSize(ft.getStats().getSize());
			entity.setTypeCriteriaAnalisysMatch(new TypeCriteriaAnalisysMatch(ft.getNumberMatchesType().getNumerOfMatches().longValue(), null));
			entity.setTypeGeneralCondition(new TypeGeneralCondition(GeneralOrConditionTypeEnum.CONDITION.getId(), null));
			
			couponMatchTeamProbValueRepository.insert(entity);
		}
	}

	private void doubleChanceProcess(CouponMatchTeam couponMatchTeam, List<DoubleChanceProbabilityDTO> dcValues) {
		for (DoubleChanceProbabilityDTO dc : dcValues) {
			CouponMatchTeamProbValue entity = new CouponMatchTeamProbValue();
			entity.setCouponMatchTeam(couponMatchTeam);
			entity.setSelectionMarketBet(new SelectionMarketBet(dc.getStats().getSelectionMarketBetId(), null, null));
			entity.setValue(dc.getStats().getValue());
			entity.setSize(dc.getStats().getSize());
			entity.setTypeCriteriaAnalisysMatch(new TypeCriteriaAnalisysMatch(dc.getNumberMatchesType().getNumerOfMatches().longValue(), null));
			entity.setTypeGeneralCondition(new TypeGeneralCondition(GeneralOrConditionTypeEnum.CONDITION.getId(), null));
			couponMatchTeamProbValueRepository.insert(entity);
		}
	}
	
}
