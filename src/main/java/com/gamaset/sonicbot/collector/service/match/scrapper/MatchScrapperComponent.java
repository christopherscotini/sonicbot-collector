package com.gamaset.sonicbot.collector.service.match.scrapper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
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

	@Autowired
	private LoginComponent login;

	private final String URL_ACADEMIA = "https://www.academiadasapostas.com/";
	
	public List<MatchResumeDTO> read() {

		List<MatchResumeDTO> matchs = new ArrayList<MatchResumeDTO>();

		try {

			Document doc = Jsoup.connect(URL_ACADEMIA).cookies(login.getCookies()).get();

			Elements trGames = doc.select("table[class=competition-today dskt]").first().select("tbody").first()
					.select("tr[type=match]");

			for (Element trGame : trGames) {

				MatchResumeDTO match = new MatchResumeDTO();
				match.setLinkMatch(trGame.select("td[class^=score]").first().select("a").first().attr("href"));
				match.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

				matchs.add(match);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matchs;
	}

}
