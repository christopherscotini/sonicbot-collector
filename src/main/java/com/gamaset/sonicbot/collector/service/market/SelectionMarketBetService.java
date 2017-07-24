package com.gamaset.sonicbot.collector.service.market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.SelectionMarketBetDTO;
import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.infra.ObjectsConverter;
import com.gamaset.sonicbot.collector.repository.SelectionMarketBetRepository;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
@Service
public class SelectionMarketBetService {

	@Autowired
	private SelectionMarketBetRepository selectionMarketBetRepository;
	
	/**
	 * 
	 * @return
	 */
	@Cacheable(cacheNames={CachingConfig.SELECT_MARKET_BET_CACHE})
	public List<SelectionMarketBetDTO> markets(){
		return ObjectsConverter.convertListSelectionMarketBet(selectionMarketBetRepository.findAll());
	}
	
}