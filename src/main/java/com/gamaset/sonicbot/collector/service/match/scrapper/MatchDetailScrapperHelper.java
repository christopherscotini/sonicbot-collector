package com.gamaset.sonicbot.collector.service.match.scrapper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.TeamDTO;
import com.gamaset.sonicbot.collector.dto.TeamMatchDTO;
import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class MatchDetailScrapperHelper {

	public List<TeamMatchDetailDTO> extractLast10MatchesByCondition(Element dataStats, HomeAwayConditionEnum teamCondition){
		Elements trGames = dataStats.select("table[class=stat-last10 stat-half-padding]");
		if(trGames.size()>2){
			trGames = trGames.get(teamCondition.ordinal()+2).select("tbody").select("tr[class~=(even|odd)]");;
			return getListMatchs(trGames, null);
		}else{
			return new ArrayList<TeamMatchDetailDTO>();
		}
	}
	
	private List<TeamMatchDetailDTO> getListMatchs(Elements trGames, TeamMatchDTO teamMatch){
		List<TeamMatchDetailDTO> dtos = new ArrayList<TeamMatchDetailDTO>();
		for (Element trGame : trGames) {
//			TeamMatchDetailDTO dto = teamMatch==null?getMatchsByCondition(trGame):getMatchesGeneral(trGame, teamMatch);
			TeamMatchDetailDTO dto = getMatchsByCondition(trGame);
			if(dto == null){
				continue;
			}
			dtos.add(dto);
		}
		return dtos;
	}
	
	private TeamMatchDetailDTO getMatchsByCondition(Element trGame) {
		TeamMatchDetailDTO dto = new TeamMatchDetailDTO();
		
		if(trGame.select("td").size() < 2){
			return null;
		}
		
		Element tdScore = trGame.select("td").get(2);
		String scoreStr = tdScore.select("a").text();
		
		if(scoreStr.trim().length()==1){
			return null;
		}
		
		TeamMatchDTO homeTeam = new TeamMatchDTO();
		homeTeam.setTeam(new TeamDTO(null, trGame.select("td").get(1).text()));
		homeTeam.setScore(Integer.valueOf(scoreStr.split("-")[0]));
		dto.setHomeTeamMatch(homeTeam);

		TeamMatchDTO awayTeam = new TeamMatchDTO();
		awayTeam.setTeam(new TeamDTO(null, trGame.select("td").get(3).text()));
		awayTeam.setScore(Integer.valueOf(scoreStr.split("-")[1]));
		dto.setAwayTeamMatch(awayTeam);
		
		return dto;
	}
	
//	private TeamMatchDetailDTO getMatchesGeneral(Element trGame, TeamMatchDTO teamMatch){
//		TeamMatchDetailDTO dto = new TeamMatchDetailDTO();
//		
//		String date = trGame.select("td").get(COLUMN_NUMBER_DATE_MATCH).text();
//		if(date.equalsIgnoreCase("Sem resultados")){return null;}
//
//		Element tdScore = trGame.select("td").get(COLUMN_NUMBER_SCORE);
//		String scoreStr = tdScore.select("a").text();
//		if(scoreStr.trim().length()==1){return null;}
//		
//		dto.setDate(date);
//		dto.setLinkMatch(tdScore.select("a").attr("href"));
//		
//		String homeTeamColumn = trGame.select("td").get(COLUMN_NUMBER_HOME_TEAM).text();
//		String awayTeamColumn = trGame.select("td").get(COLUMN_NUMBER_AWAY_TEAM).text();
//		
//		if(teamMatch.getTeam().getName().equals(homeTeamColumn)){
//			dto.setHomeTeam(
//					new TeamMatchDTO(
//							new TeamDTO(null, homeTeamColumn, null), 
//							Integer.valueOf(scoreStr.split("-")[0]), 
//							HomeAwayConditionEnum.HOME_TEAM)
//					);
//			
//			dto.setAwayTeam(
//					new TeamMatchDTO(
//							new TeamDTO(null, awayTeamColumn, null), 
//							Integer.valueOf(scoreStr.split("-")[1]), 
//							HomeAwayConditionEnum.AWAY_TEAM)
//					);
//		}else{
//			dto.setHomeTeam(
//					new TeamMatchDTO(
//							new TeamDTO(null, awayTeamColumn, null), 
//							Integer.valueOf(scoreStr.split("-")[1]), 
//							HomeAwayConditionEnum.AWAY_TEAM)
//					);
//			
//			dto.setAwayTeam(
//					new TeamMatchDTO(
//							new TeamDTO(null, homeTeamColumn, null), 
//							Integer.valueOf(scoreStr.split("-")[0]), 
//							HomeAwayConditionEnum.HOME_TEAM)
//					);
//		}
//		
//		
//		return dto;
//	}
	
}
