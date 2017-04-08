package com.gamaset.sonicbot.collector.repository;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.CompetitionSeason;

@Component
public class CompetitionSeasonRepository extends JpaGenericDao<CompetitionSeason, Long> {

	public CompetitionSeason findById(Long competitionId, Long seasonId) {

		try {
			CompetitionSeason cs = (CompetitionSeason) this.getEntityManager()
					.createQuery(
							"SELECT cs FROM CompetitionSeason cs WHERE cs.competition.id = :compId AND cs.season.id = :seasId")
					.setParameter("compId", competitionId).setParameter("seasId", seasonId).getSingleResult();
			return cs;
		} catch (NoResultException nre) {
			return null;
		}

	}
}
