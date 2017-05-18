package com.gamaset.sonicbot.collector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.CompetitionDTO;
import com.gamaset.sonicbot.collector.dto.CompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.infra.ObjectsConverter;
import com.gamaset.sonicbot.collector.repository.CompetitionRepository;
import com.gamaset.sonicbot.collector.repository.CompetitionSeasonRepository;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
@Service
public class CompetitionService {

	@Autowired
	private CompetitionRepository competitionRepository;
	@Autowired
	private CompetitionSeasonRepository competitionSeasonRepository;
	
	
	public List<CompetitionDTO> competitions(){
		return ObjectsConverter.convertListCompetition(competitionRepository.findAll());
	}

	@Cacheable(cacheNames=CachingConfig.COMP_SEASON_CACHE)
	public List<CompetitionSeasonDTO> competitionSeasons() {
		return ObjectsConverter.convertListCompSeason(competitionSeasonRepository.findAll());
	}
	
}
