package com.gamaset.sonicbot.collector.infra;

import java.util.ArrayList;
import java.util.List;

import com.gamaset.sonicbot.collector.dto.BankrollDTO;
import com.gamaset.sonicbot.collector.dto.CompetitionDTO;
import com.gamaset.sonicbot.collector.dto.CompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.dto.MarketBetDTO;
import com.gamaset.sonicbot.collector.dto.SeasonDTO;
import com.gamaset.sonicbot.collector.dto.SelectionMarketBetDTO;
import com.gamaset.sonicbot.collector.dto.TeamCompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.dto.TeamDTO;
import com.gamaset.sonicbot.collector.repository.entity.BankRoll;
import com.gamaset.sonicbot.collector.repository.entity.CompetitionSeason;
import com.gamaset.sonicbot.collector.repository.entity.Season;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;
import com.gamaset.sonicbot.collector.repository.entity.domain.MarketBet;
import com.gamaset.sonicbot.collector.repository.entity.domain.SelectionMarketBet;
import com.gamaset.sonicbot.collector.repository.entity.domain.Team;

public class ObjectsConverter {

//	===================================== DTO TO ENTITY ===================================== 
	
	public static MarketBet convert(MarketBetDTO dto){
		return new MarketBet(dto.getId(), dto.getName());
	}	
	
	public static Team convert(TeamDTO dto){
		return new Team(dto.getId(), dto.getName(), null);
	}	
	
	public static Competition convert(CompetitionDTO dto){
		return new Competition(dto.getId(), dto.getName(), dto.getUrl(), dto.getFlag(), null);
	}
	
	public static Season convert(SeasonDTO dto){
		return new Season(dto.getId(), dto.getName());
	}

	public static SelectionMarketBet convert(SelectionMarketBetDTO dto){
		return new SelectionMarketBet(dto.getId(), dto.getName(), convert(dto.getMarketBet()));
	}	
	
	public static CompetitionSeason convert(CompetitionSeasonDTO dto){
		return new CompetitionSeason(convert(dto.getCompetition()), convert(dto.getSeason()));
	}
	
	public static TeamCompetitionSeason convert(TeamCompetitionSeasonDTO dto){
		return new TeamCompetitionSeason(dto.getId(), convert(dto.getCompetitionSeason()), convert(dto.getTeam()), dto.isActive());
	}
	
	
//	===================================== ENTITY TO DTO ===================================== 

	public static MarketBetDTO convert(MarketBet entity){
		return new MarketBetDTO(entity.getId(), entity.getName());
	}	
	
	public static TeamDTO convert(Team entity){
		return new TeamDTO(entity.getId(), entity.getName(), entity.getCountry());
	}	
	
	public static SeasonDTO convert(Season entity) {
		return new SeasonDTO(entity.getId(), entity.getName());
	}
	
	public static CompetitionDTO convert(Competition entity) {
		return new CompetitionDTO(entity.getId(), entity.getName(), entity.getUrl(), entity.getFlag());
	}

	public static SelectionMarketBetDTO convert(SelectionMarketBet entity){
		return new SelectionMarketBetDTO(entity.getId(), entity.getName(), convert(entity.getMarketBet()));
	}
	
	public static CompetitionSeasonDTO convert(CompetitionSeason entity) {
		return new CompetitionSeasonDTO(entity.getId(), convert(entity.getCompetition()), convert(entity.getSeason()));
	}
	
	public static TeamCompetitionSeasonDTO convert(TeamCompetitionSeason entity){
		return new TeamCompetitionSeasonDTO(entity.getId(), convert(entity.getCompetitionSeason()), convert(entity.getTeam()), entity.isActive());
	}
	
	public static BankrollDTO convert(BankRoll entity) {
		return new BankrollDTO(entity.getId(), entity.getDate(), entity.getDescription(),
				entity.getInitialBankrollValue(), entity.getActualBankrollValue(), entity.getYieldValue(),
				entity.getYieldPercentage(), entity.getCreatedDate(), entity.getUpdatedDate());
	}

//	LISTS
	public static List<SelectionMarketBetDTO> convertListSelectionMarketBet(List<SelectionMarketBet> list) {
		List<SelectionMarketBetDTO> retzz = new ArrayList<>();
		for (SelectionMarketBet entity : list) {
			retzz.add(convert(entity));
		}
		return retzz;
	}
	
	public static List<TeamCompetitionSeasonDTO> convertListTeamCompSeason(List<TeamCompetitionSeason> list) {
		List<TeamCompetitionSeasonDTO> retzz = new ArrayList<>();
		for (TeamCompetitionSeason entity : list) {
			retzz.add(convert(entity));
		}
		return retzz;
	}
	
	public static List<CompetitionSeasonDTO> convertListCompSeason(List<CompetitionSeason> list) {
		List<CompetitionSeasonDTO> retzz = new ArrayList<>();
		for (CompetitionSeason entity : list) {
			retzz.add(convert(entity));
		}
		return retzz;
	}

	public static List<CompetitionDTO> convertListCompetition(List<Competition> list) {
		List<CompetitionDTO> retzz = new ArrayList<>();
		for (Competition entity : list) {
			retzz.add(convert(entity));
		}
		return retzz;
	}

	public static List<BankrollDTO> convertListBankroll(List<BankRoll> list) {
		List<BankrollDTO> retzz = new ArrayList<>();
		for (BankRoll entity : list) {
			retzz.add(convert(entity));
		}
		return retzz;
	}

	
}
