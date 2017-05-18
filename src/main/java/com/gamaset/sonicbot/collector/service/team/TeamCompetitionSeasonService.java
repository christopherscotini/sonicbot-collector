package com.gamaset.sonicbot.collector.service.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.TeamCompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.infra.ObjectsConverter;
import com.gamaset.sonicbot.collector.repository.TeamCompetitionSeasonRepository;

@Service
public class TeamCompetitionSeasonService {

	@Autowired
	private TeamCompetitionSeasonRepository repo;
	
	@Cacheable(cacheNames=CachingConfig.TEAM_COMP_SEAS)
	public List<TeamCompetitionSeasonDTO> list(){
		return ObjectsConverter.convertListTeamCompSeason(repo.findAll());
	}

	@Cacheable(cacheNames=CachingConfig.TEAM_COMP_SEAS_BY_COMP)
	public List<TeamCompetitionSeasonDTO> listByCompetition(Long competitionId) {
		return ObjectsConverter.convertListTeamCompSeason(repo.findByCompetition(competitionId));
	}
	
}
