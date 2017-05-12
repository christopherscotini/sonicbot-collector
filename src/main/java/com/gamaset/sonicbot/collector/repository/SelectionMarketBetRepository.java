package com.gamaset.sonicbot.collector.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.domain.SelectionMarketBet;

@Component
public class SelectionMarketBetRepository extends JpaGenericDao<SelectionMarketBet, Long>{

	@Autowired
	private CachingConfig caching;
	
	
	@Override
	public SelectionMarketBet insert(SelectionMarketBet entity) {
		caching.resetCacheSelectionMarketbet();
		return super.insert(entity);
	}
}
