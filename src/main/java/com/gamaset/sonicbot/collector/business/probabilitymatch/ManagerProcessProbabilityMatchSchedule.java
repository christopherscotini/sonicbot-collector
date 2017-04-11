package com.gamaset.sonicbot.collector.business.probabilitymatch;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchTeamCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchTeamProbValueCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator.CompetitionSeasonValidatorComponent;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.repository.entity.Coupon;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeam;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class ManagerProcessProbabilityMatchSchedule {

	
	@Autowired
	private CouponCreateProcessComponent couponCreateProcessComponent;
	@Autowired
	private CouponMatchCreateProcessComponent couponMatchCreateProcessComponent;
	@Autowired
	private CouponMatchTeamCreateProcessComponent couponMatchTeamCreateProcessComponent;
	@Autowired
	private CouponMatchTeamProbValueCreateProcessComponent couponMatchTeamProbValueCreateProcessComponent;
	@Autowired
	private CompetitionSeasonValidatorComponent competitionSeasonValidatorComponent;
	
	@Transactional
	public void save(List<MatchDataDTO> matchesData){
		
		Coupon coupon = couponCreateProcessComponent.process(matchesData.get(0).getMatchResume().getDate());

		for (MatchDataDTO matchDataDTO : matchesData) {
			
			if(!validateWithMatchesContainsAnalytics(matchDataDTO.getMatchstatistics().getHomeTeamStats())){
				continue;
			}
			if(!validateWithMatchesContainsAnalytics(matchDataDTO.getMatchstatistics().getAwayTeamStats())){
				continue;
			}
			
			//IGNORA CASO A COMPETICAO NAO ESTEJA CADASTRADA
			if (!competitionSeasonValidatorComponent
					.validate(matchDataDTO.getMatchResume().getCompetitionSeason())) {
				continue;
			}
			
			try{
				CouponMatch couponMatch = couponMatchCreateProcessComponent.process(coupon, matchDataDTO);
				
				CouponMatchTeam couponMatchHomeTeam = couponMatchTeamCreateProcessComponent.process(couponMatch, couponMatch.getHomeTeam());
				couponMatchTeamProbValueCreateProcessComponent.process(couponMatchHomeTeam, matchDataDTO.getMatchstatistics().getHomeTeamStats());
	
				CouponMatchTeam couponMatchAwayTeam = couponMatchTeamCreateProcessComponent.process(couponMatch, couponMatch.getAwayTeam());
				couponMatchTeamProbValueCreateProcessComponent.process(couponMatchAwayTeam, matchDataDTO.getMatchstatistics().getAwayTeamStats());
			}catch (ConstraintViolationException c){
				System.err.println(c.getErrorCode() +" - "+ c.getConstraintName());
			}
			
		}
		
	}

	private boolean validateWithMatchesContainsAnalytics(TeamStatisticsDTO teamStats) {
		if(teamStats.getDoubleChanceProbabilities().isEmpty() || teamStats.getFulltimeProbabilities().isEmpty() || 
				teamStats.getGoalsProbabilities().isEmpty()){
			return false;
		}
		return true;
	}

}
