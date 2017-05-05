package com.gamaset.sonicbot.collector.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.odds.EventBettingDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.FulltimeProbabilityDTO;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;
import com.gamaset.sonicbot.collector.service.competition.CompetitionService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class BettingOddsService {

	@Autowired
	private CompetitionService competitionService;
	
	public void getOddsByDate(String date, List<MatchDataDTO> datas) {
		
		ObjectMapper mapper = new ObjectMapper().
				setSerializationInclusion(Include.NON_NULL).
				configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true).
				configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true).
				configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		
		try {//Nao le eventos passados
			HttpResponse<JsonNode> response = Unirest.get("https://bettingodds-bettingoddsapi-v1.p.mashape.com/events/"+date)
					.header("X-Mashape-Key", "h9N1oii7dNmsh0kwF08FMjUDQeLVp1mLYcBjsnyp8M7h08Sq0D")
					.header("Accept", "application/json")
					.asJson();
			List<EventBettingDTO> eventsBettingOdds = new ArrayList<>();
			for (int i = 0; i < response.getBody().getObject().length(); i++) {
				String father = (String) response.getBody().getObject().names().get(i);
				String dataSon = response.getBody().getObject().get(father).toString();
				eventsBettingOdds.add(mapper.readValue(dataSon, EventBettingDTO.class));
			}
			
			List<EventBettingDTO> filterEvents = filterEvents(eventsBettingOdds);
			
			populateOddValues(datas, filterEvents);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void populateOddValues(List<MatchDataDTO> datas, List<EventBettingDTO> filterEvents){
		for (MatchDataDTO match : datas) {
			for (EventBettingDTO event : filterEvents) {
				if(match.getMatchResume().getHomeTeamMatch().getTeam().getBettingTeamId().
						equals(event.getHome().getBettingTeamId())){
					for (FulltimeProbabilityDTO probs : match.getMatchstatistics().getHomeTeamStats().getFulltimeProbabilities()) {
//						probs.getStats().
					}
				}
			}
		}
	}
	
	private List<EventBettingDTO> filterEvents(List<EventBettingDTO> events){
		List<Competition> competitionsAvailable = competitionService.competitions();
		List<EventBettingDTO> filtered = new ArrayList<>();
		for (EventBettingDTO event : events) {
			if(event.getSport().getId().equals(10) && validOdd(event) && validCompetition(event, competitionsAvailable)){// 10 = Soccer
				System.out.println(String.format("%s\t%s\t%s", 
						event.getHome().getId(),
						event.getHome().getName(),
						event.getLeague().getName()
						));
				System.out.println(String.format("%s\t%s\t%s", 
						event.getAway().getId(),
						event.getAway().getName(),
						event.getLeague().getName()
						));
				filtered.add(event);
			}
		}
		
		return filtered;
	}
	
	private boolean validCompetition(EventBettingDTO event, List<Competition> competitionsAvailable){
		return competitionsAvailable.stream().anyMatch(comp -> comp.getCompIdbetOdd().equals(event.getLeague().getId().intValue()));
	}
	
	private boolean validOdd(EventBettingDTO event){
		if(Objects.isNull(event.getOdds()) || 
				Objects.isNull(event.getOdds().getFulltimeOdd()) ||
				Objects.isNull(event.getOdds().getFulltimeOdd().getHomeWinOdd()) || 
				event.getOdds().getFulltimeOdd().getHomeWinOdd().isEmpty()){
			return false;
		}
		if(Objects.nonNull(event.getOdds().getFulltimeOdd().getHomeWinOdd().get(0).getOdd()) && event.getOdds().getFulltimeOdd().getHomeWinOdd().get(0).getOdd() > 1.40){
			return true;
		}
		return false;
	}
}
