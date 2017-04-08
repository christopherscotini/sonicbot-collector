package com.gamaset.sonicbot.collector.repository;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;

@Component
public class TeamCompetitionSeasonRepository extends JpaGenericDao<TeamCompetitionSeason, Long> {

	public TeamCompetitionSeason findById(Long teamId, Long competitionId, Long seasonId) {

		try {
			return (TeamCompetitionSeason) this.getEntityManager()
					.createQuery("SELECT tcs FROM TeamCompetitionSeason tcs WHERE tcs.team.id = :teamId "
							+ "AND tcs.competitionSeason.competition.id = :competitionId "
							+ "AND tcs.competitionSeason.season.id = :seasonId")
					.setParameter("teamId", teamId).setParameter("competitionId", competitionId)
					.setParameter("seasonId", seasonId).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
