package com.gamaset.sonicbot.collector.service.academia.matchdetail.scrapper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.PositionDTO;
import com.gamaset.sonicbot.collector.dto.TeamDTO;
import com.gamaset.sonicbot.collector.dto.TeamMatchDTO;
import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.infra.constants.PositionConditionEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class MatchDetailAcademiaScrapperHelper {

	public List<TeamMatchDetailDTO> extractLast10MatchesByCondition(Element dataStats,
			HomeAwayConditionEnum teamCondition) {
		Elements trGames = dataStats.select("table[class=stat-last10 stat-half-padding]");
		if (trGames.size() > 2) {
			trGames = trGames.get(teamCondition.ordinal() + 2).select("tbody").select("tr[class~=(even|odd)]");
			return getListMatchs(trGames, null);
		} else {
			return new ArrayList<TeamMatchDetailDTO>();
		}
	}

	private List<TeamMatchDetailDTO> getListMatchs(Elements trGames, TeamMatchDTO teamMatch) {
		List<TeamMatchDetailDTO> dtos = new ArrayList<TeamMatchDetailDTO>();
		for (Element trGame : trGames) {
			TeamMatchDetailDTO dto = getMatchsByCondition(trGame);
			if (dto == null) {
				continue;
			}
			dtos.add(dto);
		}
		return dtos;
	}

	private TeamMatchDetailDTO getMatchsByCondition(Element trGame) {
		TeamMatchDetailDTO dto = new TeamMatchDetailDTO();

		if (trGame.select("td").size() < 2) {
			return null;
		}

		Element tdScore = trGame.select("td").get(2);
		String scoreStr = tdScore.select("a").text();

		if (scoreStr.trim().length() == 1) {
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

	public List<PositionDTO> extractPosition(Element dataStats, TeamMatchDTO teamMatch) {
		List<PositionDTO> dtos = new ArrayList<PositionDTO>();

		for (int i = 0; i < 3; i++) {
			Elements trTables = dataStats.select("table[class=results competition-rounds competition-half-padding]");
			if (trTables.size() == 0) {
				return null;
			}

			trTables = trTables.get(i).select("tbody").select("tr");

			if (trTables.size() > 2) {
				PositionDTO dto = getPosition(trTables, teamMatch, i);
				if (dto != null) {
					dtos.add(dto);
				}
			}
		}

		return dtos;
	}

	private PositionDTO getPosition(Elements trTables, TeamMatchDTO teamMatch, int condition) {
		for (Element trPosition : trTables) {
			if (trPosition.select("td").size() < 8) {
				return null;
			}

			if (trPosition.select("td").get(1).text().trim().equals(teamMatch.getTeam().getName())) {
				PositionDTO dto = new PositionDTO();
				dto.setCondition(PositionConditionEnum.values()[condition]);
				dto.setPosition(Integer.parseInt(trPosition.select("td").get(0).text()));

				return dto;
			}
		}

		return null;
	}

}
