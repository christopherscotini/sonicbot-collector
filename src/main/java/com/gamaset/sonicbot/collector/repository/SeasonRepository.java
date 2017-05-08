package com.gamaset.sonicbot.collector.repository;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.Season;

@Component
public class SeasonRepository extends JpaGenericDao<Season, Long> {

	@Override
	public Season insert(Season entity) {
		entity.setActive(true);
		return super.insert(entity);
	}

}