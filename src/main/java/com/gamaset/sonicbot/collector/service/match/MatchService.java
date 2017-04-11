package com.gamaset.sonicbot.collector.service.match;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.MatchSeriesDTO;
import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.service.match.scrapper.MatchScrapperComponent;

/**
 * Classe de serviço que cuida das partidas
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Service
public class MatchService {
	
	@Autowired
	private MatchScrapperComponent scrapper;
	
	private final String URL_ACADEMIA = "https://www.academiadasapostas.com/stats/livescores/popup/";

//	@Cacheable(cacheNames = CachingConfig.MATCH_BY_DATE_CHACHE)
	public MatchSeriesDTO listByDate(String date){
		//TODO verify if necessary any validator

		String url = (date == null || date.trim().equals("")) ? URL_ACADEMIA : URL_ACADEMIA + DateUtils.convertDateStringToTimestamp(date) + "/";
		
		MatchSeriesDTO matchSeries = scrapper.scrap(getAvailableComps(), url);
		
		System.out.println(">> matches found: "+matchSeries.getMatches().size());
		
		return matchSeries;
	}
	
	
	/**
	 * Adicionar Consulta via banco de dados
	 * @return
	 */
	private Set<Long> getAvailableComps(){
		Set<Long> availableCompetitionsId = new HashSet<>();
		availableCompetitionsId.add(9L);
		availableCompetitionsId.add(11L);
		availableCompetitionsId.add(87L);
		availableCompetitionsId.add(88L);
		availableCompetitionsId.add(26L);
		availableCompetitionsId.add(89L);
		availableCompetitionsId.add(24L);
		availableCompetitionsId.add(51L);
		availableCompetitionsId.add(136L);
		availableCompetitionsId.add(30L);
		availableCompetitionsId.add(43L);
		availableCompetitionsId.add(7L);
		availableCompetitionsId.add(12L);
		availableCompetitionsId.add(33L);
		availableCompetitionsId.add(16L);
		availableCompetitionsId.add(17L);
		availableCompetitionsId.add(107L);
		availableCompetitionsId.add(108L);
		availableCompetitionsId.add(1L);
		availableCompetitionsId.add(5L);
		availableCompetitionsId.add(67L);
		availableCompetitionsId.add(8L);
		availableCompetitionsId.add(70L);
		availableCompetitionsId.add(15L);
		availableCompetitionsId.add(34L);
		availableCompetitionsId.add(13L);
		availableCompetitionsId.add(14L);
		availableCompetitionsId.add(109L);
		availableCompetitionsId.add(110L);
		availableCompetitionsId.add(29L);
		availableCompetitionsId.add(119L);
		availableCompetitionsId.add(63L);
		availableCompetitionsId.add(100L);
		availableCompetitionsId.add(82L);
		availableCompetitionsId.add(121L);
		availableCompetitionsId.add(122L);
		availableCompetitionsId.add(28L);
		availableCompetitionsId.add(27L);
		availableCompetitionsId.add(19L);
		availableCompetitionsId.add(125L);
		availableCompetitionsId.add(59L);
		availableCompetitionsId.add(61L);
		availableCompetitionsId.add(155L);
		return availableCompetitionsId;
	}

}
