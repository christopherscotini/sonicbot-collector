package com.gamaset.sonicbot.collector.business.probabilitymatch.process;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.CouponMatchTeamRepository;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeam;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class CouponMatchTeamCreateProcessComponent {

	private CouponMatchTeamRepository couponMatchTeamRepository;
	
	public CouponMatchTeam process(CouponMatch couponMatch, TeamCompetitionSeason teamCompetitionSeason){
		
		CouponMatchTeam entity = new CouponMatchTeam();
		entity.setCouponMatch(couponMatch);
		entity.setTeamCompetitionSeason(teamCompetitionSeason);
		
		return couponMatchTeamRepository.insert(entity);
	}
	
}
