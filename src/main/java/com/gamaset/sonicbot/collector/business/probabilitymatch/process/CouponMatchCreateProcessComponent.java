package com.gamaset.sonicbot.collector.business.probabilitymatch.process;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator.TeamCompetitionSeasonValidatorComponent;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.infra.constants.PositionConditionEnum;
import com.gamaset.sonicbot.collector.repository.CouponMatchRepository;
import com.gamaset.sonicbot.collector.repository.entity.Coupon;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class CouponMatchCreateProcessComponent {
	
	@Autowired
	private TeamCompetitionSeasonValidatorComponent teamCompetitionSeasonValidatorComponent;
	
	@Autowired
	private CouponMatchRepository couponMatchRepository;
	
	/**
	 * 
	 * @param coupon
	 * @param matchDataDTO
	 * @return
	 */
	public CouponMatch process(Coupon coupon, MatchDataDTO matchDataDTO){
		
		TeamCompetitionSeason homeTeam = teamCompetitionSeasonValidatorComponent.validate(matchDataDTO.getMatchResume().getHomeTeamMatch().getTeam(), matchDataDTO.getMatchResume().getCompetitionSeason());
		TeamCompetitionSeason awayTeam = teamCompetitionSeasonValidatorComponent.validate(matchDataDTO.getMatchResume().getAwayTeamMatch().getTeam(), matchDataDTO.getMatchResume().getCompetitionSeason());
		
		CouponMatch entity = new CouponMatch();
		entity.setId(matchDataDTO.getMatchResume().getMatchId());
		entity.setCoupon(coupon);
		entity.setMatchStatus(matchDataDTO.getMatchResume().getMatchStatus());
		entity.setHomeTeam(homeTeam);
		entity.setAwayTeam(awayTeam);
		entity.setScoreHomeTeam(matchDataDTO.getMatchResume().getHomeTeamMatch().getScore());
		entity.setScoreAwayTeam(matchDataDTO.getMatchResume().getAwayTeamMatch().getScore());
		entity.setUrlMatch(matchDataDTO.getMatchResume().getLinkMatch());
		
		matchDataDTO.getMatchstatistics().getHomeTeamStats().getPositions().forEach(pos -> {
			if(pos.getCondition().equals(PositionConditionEnum.GENERAL)){
				entity.setPosHomeTeam(pos.getPosition());
			}
		});
		matchDataDTO.getMatchstatistics().getAwayTeamStats().getPositions().forEach(pos -> {
			if(pos.getCondition().equals(PositionConditionEnum.GENERAL)){
				entity.setPosAwayTeam(pos.getPosition());
			}
		});
		entity.setCreatedDate(new Date());
		entity.setUpdatedDate(entity.getCreatedDate());
		
		return couponMatchRepository.insert(entity);
	}
	
}
