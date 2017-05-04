package com.gamaset.sonicbot.collector.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamaset.sonicbot.collector.dto.odds.EventBettingDTO;
import com.gamaset.sonicbot.collector.dto.odds.SportBettingDTO;
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
	
	public void getOddsByDate(String date) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		
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
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnirestException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private List<EventBettingDTO> filterEvents(List<EventBettingDTO> events){
		List<Competition> competitionsAvailable = competitionService.competitions();
		List<EventBettingDTO> filtered = new ArrayList<>();
		
		for (EventBettingDTO event : events) {
			boolean available = competitionsAvailable.stream().anyMatch(comp -> comp.getCompIdbetOdd().equals(event.getLeague().getId().intValue()));
			if(event.getSport().getId().equals(10) && available){// 10 = Soccer
				filtered.add(event);
			}
		}
		
		return filtered;
	}
	
}
