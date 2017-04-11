package com.gamaset.sonicbot.collector.business.probabilitymatch.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator.TeamCompetitionSeasonValidatorComponent;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
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
		entity.setCoupon(coupon);
		entity.setHomeTeam(homeTeam);
		entity.setAwayTeam(awayTeam);
		entity.setScoreHomeTeam(matchDataDTO.getMatchResume().getHomeTeamMatch().getScore());
		entity.setScoreAwayTeam(matchDataDTO.getMatchResume().getAwayTeamMatch().getScore());
		entity.setUrlMatch(matchDataDTO.getMatchResume().getLinkMatch());
		if(matchDataDTO.getMatchstatistics().getHomeTeamStats().getPositions() != null){
			entity.setPosHomeTeam(matchDataDTO.getMatchstatistics().getHomeTeamStats().getPositions().get(0).getPosition());
			entity.setPosAwayTeam(matchDataDTO.getMatchstatistics().getAwayTeamStats().getPositions().get(0).getPosition());
		}

		if(matchDataDTO.getMatchResume().getHomeTeamMatch().getScore() > matchDataDTO.getMatchResume().getAwayTeamMatch().getScore()){
			entity.setWinnerTeam(homeTeam);
		}else if(matchDataDTO.getMatchResume().getHomeTeamMatch().getScore() < matchDataDTO.getMatchResume().getAwayTeamMatch().getScore()){
			entity.setWinnerTeam(awayTeam);
		}//EMPATE vai NULL
		
		return couponMatchRepository.insert(entity);
	}
	
}
