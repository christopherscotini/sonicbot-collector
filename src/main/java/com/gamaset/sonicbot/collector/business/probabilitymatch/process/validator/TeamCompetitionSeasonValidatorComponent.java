package com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.CompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.dto.TeamDTO;
import com.gamaset.sonicbot.collector.infra.exception.NoDataFoundException;
import com.gamaset.sonicbot.collector.repository.CompetitionSeasonRepository;
import com.gamaset.sonicbot.collector.repository.TeamCompetitionSeasonRepository;
import com.gamaset.sonicbot.collector.repository.TeamRepository;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class TeamCompetitionSeasonValidatorComponent {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private TeamCompetitionSeasonRepository teamCompetitionSeasonRepository;
	@Autowired
	private CompetitionSeasonRepository competitionSeasonRepository;
	
	public TeamCompetitionSeason validate(TeamDTO team, CompetitionSeasonDTO competitionSeason){
		
		if(teamRepository.findById(team.getId()) == null){
			throw new NoDataFoundException(String.format("teamId:%d, teamName:%s", team.getId(), team.getName()));
		}
		
		Assert.assertNotNull("competitionId cannot be null", competitionSeason.getCompetition().getId());
		Assert.assertNotNull("sessionId cannot be null", competitionSeason.getSeason().getId());
		
		TeamCompetitionSeason teamCS = teamCompetitionSeasonRepository.findById(team.getId(), competitionSeason.getCompetition().getId(), competitionSeason.getSeason().getId());
		if(teamCS == null){
			TeamCompetitionSeason tcs = new TeamCompetitionSeason(
					teamRepository.findById(team.getId()), 
					competitionSeasonRepository.findById(competitionSeason.getCompetition().getId(), competitionSeason.getSeason().getId())
					);
			
			return teamCompetitionSeasonRepository.insert(tcs);
		}
		
		return teamCS;
		
	}

}
