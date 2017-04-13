package com.gamaset.sonicbot.collector.service.academia.matchdetail.scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.detail.MatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.detail.MatchDetailTeamDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.service.academia.login.LoginAcademiaService;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class MatchDetailAcademiaScrapperComponent {

	@Autowired
	private LoginAcademiaService login;
	@Autowired
	private MatchDetailAcademiaScrapperHelper helper;

	public MatchDetailDTO scrap(MatchResumeDTO match) {
		MatchDetailDTO dto = new MatchDetailDTO();

		try {
			Document doc = Jsoup.connect(match.getLinkMatch()).cookies(login.getCookies()).get();

			Element dataStats = doc.select("div[class=stats-container-left]").first();

			MatchDetailTeamDTO homeTeamDetail = new MatchDetailTeamDTO();
			homeTeamDetail.setMatchesByCondition(
					helper.extractLast10MatchesByCondition(dataStats, HomeAwayConditionEnum.HOME_TEAM));
			homeTeamDetail.setPositions(helper.extractPosition(dataStats, match.getHomeTeamMatch()));
			MatchDetailTeamDTO awayTeamDetail = new MatchDetailTeamDTO();
			awayTeamDetail.setMatchesByCondition(
					helper.extractLast10MatchesByCondition(dataStats, HomeAwayConditionEnum.AWAY_TEAM));
			awayTeamDetail.setPositions(helper.extractPosition(dataStats, match.getAwayTeamMatch()));

			dto.setMatchDetailHomeTeam(homeTeamDetail);
			dto.setMatchDetailAwayTeam(awayTeamDetail);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dto;
	}

}
