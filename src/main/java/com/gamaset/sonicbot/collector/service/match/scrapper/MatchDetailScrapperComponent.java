package com.gamaset.sonicbot.collector.service.match.scrapper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.detail.MatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.detail.MatchDetailTeamDTO;
import com.gamaset.sonicbot.collector.infra.utils.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.service.login.LoginComponent;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class MatchDetailScrapperComponent {

	@Autowired
	private LoginComponent login;
	@Autowired
	private MatchDetailScrapperHelper helper;
	
	public MatchDetailDTO scrap(MatchResumeDTO match){
		MatchDetailDTO dto = new MatchDetailDTO();
		
		try {
			Document doc = Jsoup.connect(match.getLinkMatch()).cookies(login.getCookies()).get();
			
			Element dataStats = doc.select("div[class=stats-container-left]").first();
			
			MatchDetailTeamDTO homeTeamDetail = new MatchDetailTeamDTO();
			homeTeamDetail.setMatchesByCondition(helper.extractLast10MatchesByCondition(dataStats, HomeAwayConditionEnum.HOME_TEAM));
			
			dto.setMatchDetailHomeTeam(homeTeamDetail);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	
}
