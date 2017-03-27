package com.gamaset.sonicbot.collector.service.match.scrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.CompetitionDTO;
import com.gamaset.sonicbot.collector.dto.CompetitionSeasonDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.dto.MatchStatusEnum;
import com.gamaset.sonicbot.collector.dto.TeamDTO;
import com.gamaset.sonicbot.collector.dto.TeamMatchDTO;
import com.gamaset.sonicbot.collector.infra.exception.scrapper.FormatValueScrapperException;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.infra.utils.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.infra.utils.NumberUtils;
import com.gamaset.sonicbot.collector.service.login.LoginComponent;



/**
 * Componente responsavel pela leitura dos jogos no academia das apostas.
 * 
 * @author Christopher Rozario
 * 
 * @since 1.0.0
 * 
 */
@Component
public class MatchScrapperComponent {

	private static final Logger log = Logger.getLogger(MatchScrapperComponent.class.getName());
	
	@Autowired
	private LoginComponent login;

	private final String URL_ACADEMIA = "https://www.academiadasapostas.com/";
	
	public MatchSeriesDTO read(Set<Long> availableCompetitionsId) {

		MatchSeriesDTO dto = new MatchSeriesDTO();

		try {

			Document doc = Jsoup.connect(URL_ACADEMIA).cookies(login.getCookies()).get();

			Elements trGames = doc.select("table[class=competition-today dskt]").first().select("tbody").first()
					.select("tr[type=match]");

			dto.setMatches(new ArrayList<MatchResumeDTO>());

			for (Element trGame : trGames) {
				MatchResumeDTO match = new MatchResumeDTO();
				
				match.setMatchStatus(findMatchStatus(trGame.select("td[class^=status]").first()));
				if(match.getMatchStatus() == MatchStatusEnum.ADIADO || 
						match.getMatchStatus() == MatchStatusEnum.CANCELADO){
					continue;
				}

				match.setCompetitionSeason(new CompetitionSeasonDTO(findCompetition(trGame), null));
				if(!availableCompetitionsId.contains(match.getCompetitionSeason().getCompetition().getId())){
					continue;
				}
				match.setMatchId(findMatchId(trGame));
				match.setLinkMatch(findLinkMatch(trGame));
				match.setHomeTeamMatch(extractTeam(trGame, HomeAwayConditionEnum.HOME_TEAM));
				match.setAwayTeamMatch(extractTeam(trGame, HomeAwayConditionEnum.AWAY_TEAM));
				dto.getMatches().add(match);
			}
			
			if(dto.getMatches().size()>0){
				dto.setDate(findDate(dto.getMatches().get(0).getLinkMatch()));
			}
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}

		return dto;
	}
	
	private Long findMatchId(Element trGame){
		String urlGame = trGame.select("td[class^=score]").first().select("a").first().attr("href");
		try{
			return Long.valueOf(urlGame.substring(urlGame.lastIndexOf('/')+1));
		}catch(NumberFormatException nfe){
			log.severe("ID DA PARTIDA INVÁLIDO.\n"+nfe.getMessage());
			throw new FormatValueScrapperException("matchId cannot be converted to Long");
		}
	}
	
	private String findLinkMatch(Element trGame){
		return trGame.select("td[class^=score]").first().select("a").first().attr("href");
	}

	private MatchStatusEnum findMatchStatus(Element td) {
		if(td.select("span[class^=game_running Playing]").size() > 0){
			return MatchStatusEnum.EM_ANDAMENTO;
		}
		
		String status = td.select("span").first().text().trim();
		if(MatchStatusEnum.ADIADO.getDescriptionStatus().equals(status)){
			return MatchStatusEnum.ADIADO;
		}
		if(MatchStatusEnum.CANCELADO.getDescriptionStatus().equals(status)){
			return MatchStatusEnum.CANCELADO;
		}
		if(MatchStatusEnum.AGUARDANDO.getDescriptionStatus().equals(status)){
			return MatchStatusEnum.AGUARDANDO;
		}
		if(MatchStatusEnum.TERMINADO.getDescriptionStatus().equals(status)){
			return MatchStatusEnum.TERMINADO;
		}
		
		return null;
	}
	
	private TeamMatchDTO extractTeam(Element trGame, HomeAwayConditionEnum type){
		TeamMatchDTO teamMatch = new TeamMatchDTO();
		TeamDTO team = new TeamDTO();
		teamMatch.setTeam(team);
		teamMatch.setScore(findScore(trGame, type));
		team.setName(trGame.select(String.format("td[class^=team-%s]", type.getConditionCodeString())).first().text());
		return teamMatch;
	}	
	
	private Integer findScore(Element trGame, HomeAwayConditionEnum type) {
		return NumberUtils.converToInteger(trGame.select("td[class^=score]").first().select(String.format("span[class=fs_%S]", type.getConditionCodeString())).text());
	}
	
	private CompetitionDTO findCompetition(Element trGame){
		CompetitionDTO comp = new CompetitionDTO();
		Element trComp = trGame.select("td[class^=flag tipsy-active]").select("a[class=a-flag]").first();
		comp.setId(Long.valueOf(trGame.attr("competitionid")));
		comp.setName(trComp.attr("title"));
		comp.setLink(trComp.attr("href"));
		return comp;
	}

	private String findDate(String url) throws IOException{
		Document doc = Jsoup.connect(url).cookies(login.getCookies()).get();
		Element gameHeadInfo = doc.
				select("div[class=stats-game-head]").first().
				select("td[class=stats-game-head-date]").
				select("ul").get(1).
				select("li[class=gamehead]").first();
		return DateUtils.convertDateInfoMatchStringToDateStringYYYY_MM_DD(gameHeadInfo.text());
	}
}
