package com.gamaset.sonicbot.collector.service.match;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
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
	
	public List<MatchResumeDTO> listByDate(){
		//TODO veriry if necessary any validator
		
		return scrapper.read();
		
	}

}
