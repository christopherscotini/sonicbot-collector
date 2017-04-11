package com.gamaset.sonicbot.collector.business.probabilitymatch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchTeamCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.CouponMatchTeamProbValueCreateProcessComponent;
import com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator.CompetitionSeasonValidatorComponent;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
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
public class ManagerProcessProbabilityMatch {

	
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
		
		Coupon coupon = couponCreateProcessComponent.process(matchDataDTO.getMatchResume().getDate());

		for (MatchDataDTO matchDataDTO : matchesData) {
			matchDataDTO.getMatchstatistics().getHomeTeamStats().getDoubleChanceProbabilities().size()>0
			
			//IGNORA CASO A COMPETICAO NAO ESTEJA CADASTRADA
			if (!competitionSeasonValidatorComponent
					.validate(matchDataDTO.getMatchResume().getCompetitionSeason())) {
				continue;
			}
			
			CouponMatch couponMatch = couponMatchCreateProcessComponent.process(coupon, matchDataDTO);
			
			CouponMatchTeam couponMatchHomeTeam = couponMatchTeamCreateProcessComponent.process(couponMatch, couponMatch.getHomeTeam());
			couponMatchTeamProbValueCreateProcessComponent.process(couponMatchHomeTeam, matchDataDTO.getMatchstatistics().getHomeTeamStats());

			CouponMatchTeam couponMatchAwayTeam = couponMatchTeamCreateProcessComponent.process(couponMatch, couponMatch.getAwayTeam());
			couponMatchTeamProbValueCreateProcessComponent.process(couponMatchAwayTeam, matchDataDTO.getMatchstatistics().getAwayTeamStats());
			
		}
		
	}

}
