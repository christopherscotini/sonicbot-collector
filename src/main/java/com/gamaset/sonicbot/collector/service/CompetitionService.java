package com.gamaset.sonicbot.collector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.repository.CompetitionRepository;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;

@Service
public class CompetitionService {

	@Autowired
	private CompetitionRepository competitionRepository;
	
	public List<Competition> competitions(){
		return competitionRepository.findAll();
	}
	
}
