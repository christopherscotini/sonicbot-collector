package com.gamaset.sonicbot.collector.service.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.repository.TeamCompetitionSeasonRepository;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;

@Service
public class TeamCompetitionSeasonService {

	@Autowired
	private TeamCompetitionSeasonRepository repo;
	
	public List<TeamCompetitionSeason> list(){
		return repo.findAll();
	}
	
}
