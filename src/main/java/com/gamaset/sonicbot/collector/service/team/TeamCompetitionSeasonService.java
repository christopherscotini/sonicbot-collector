package com.gamaset.sonicbot.collector.service.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.repository.TeamCompetitionSeasonRepository;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;

@Service
public class TeamCompetitionSeasonService {

	@Autowired
	private TeamCompetitionSeasonRepository repo;
	
	@Cacheable(cacheNames=CachingConfig.TEAM_COMP_SEAS)
	public List<TeamCompetitionSeason> list(){
		return repo.findAll();
	}

	public List<TeamCompetitionSeason> listByCompetition(Long competitionId) {
		return repo.findByCompetition(competitionId);
	}
	
}
