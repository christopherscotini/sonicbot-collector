package com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator;

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

	@Autowired
	private CompetitionRepository compRepository;
	@Autowired
	private CompetitionSeasonRepository compSeasonRepository;
	@Autowired
	private SeasonRepository seasonRepository;

	public boolean validate(CompetitionSeasonDTO dto) {
		
		if (compSeasonRepository.findById(dto.getCompetition().getId(), dto.getSeason().getId()) == null)  {

			Competition competition = compRepository.findById(dto.getCompetition().getId());
			if (competition == null) {
				System.out.println(String.format(">__ Competition not found: %d - %s", dto.getCompetition().getId(), dto.getCompetition().getName()));
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
