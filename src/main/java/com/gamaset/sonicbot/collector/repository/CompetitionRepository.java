package com.gamaset.sonicbot.collector.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;

@Component
public class CompetitionRepository extends JpaGenericDao<Competition, Long> {

	@Override
	public List<Competition> findAll() {
		return getEntityManager().createQuery("FROM Competition c ORDER BY c.country.name asc, c.name asc").getResultList();
	}

}