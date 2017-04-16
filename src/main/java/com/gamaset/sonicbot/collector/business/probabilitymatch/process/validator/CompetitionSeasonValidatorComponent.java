package com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator;

import java.util.Objects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.CompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.repository.CompetitionRepository;
import com.gamaset.sonicbot.collector.repository.CompetitionSeasonRepository;
import com.gamaset.sonicbot.collector.repository.SeasonRepository;
import com.gamaset.sonicbot.collector.repository.entity.CompetitionSeason;
import com.gamaset.sonicbot.collector.repository.entity.Season;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;

@Component
public class CompetitionSeasonValidatorComponent {

	private static final Logger LOG = LogManager.getLogger(CompetitionSeasonValidatorComponent.class);
	
	
	@Autowired
	private CompetitionRepository compRepository;
	@Autowired
	private CompetitionSeasonRepository compSeasonRepository;
	@Autowired
	private SeasonRepository seasonRepository;

	public boolean validate(CompetitionSeasonDTO dto) {
		
		if(Objects.isNull(dto.getCompetition().getId()) || Objects.isNull(dto.getSeason().getId())){
			LOG.info(String.format(">__ CompetitionSeason not found: %d - %s", dto.getCompetition().getId(), dto.getSeason().getId()));
			return false;
		}
		
		if (compSeasonRepository.findById(dto.getCompetition().getId(), dto.getSeason().getId()) == null)  {

			Competition competition = compRepository.findById(dto.getCompetition().getId());
			if (competition == null) {
				LOG.info(String.format(">__ Competition not found: %d - %s", dto.getCompetition().getId(), dto.getCompetition().getName()));
				return false;
			}

			CompetitionSeason cs = new CompetitionSeason();
			cs.setCompetition(competition);
			
			Season season = seasonRepository.findById(dto.getSeason().getId());
			if (season == null) {
				cs.setSeason(seasonRepository.insert(new Season(dto.getSeason().getId(), dto.getSeason().getName())));
				compSeasonRepository.insert(cs);
			} else{
				compSeasonRepository.insert(cs);
			}
		}

		return true;
	}

}
