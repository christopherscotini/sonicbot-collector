package com.gamaset.sonicbot.collector.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.TeamCompetitionSeason;

@Component
public class TeamCompetitionSeasonRepository extends JpaGenericDao<TeamCompetitionSeason, Long> {

	@Autowired
	private CachingConfig caching;
	
	@Override
	public TeamCompetitionSeason insert(TeamCompetitionSeason entity) {
		entity.setActive(true);
		TeamCompetitionSeason insert = super.insert(entity);
		caching.resetCacheTeamCompSeason();
		caching.resetCacheTeamCompSeasonByCompetition();
		return insert;
	}
	
	public TeamCompetitionSeason findById(Long teamId, Long competitionId, Long seasonId) {

		try {
			return (TeamCompetitionSeason) this.getEntityManager()
					.createQuery("SELECT tcs FROM TeamCompetitionSeason tcs WHERE tcs.team.id = :teamId "
							+ "AND tcs.competitionSeason.competition.id = :competitionId "
							+ "AND tcs.competitionSeason.season.id = :seasonId "
							+ "AND tcs.active = 1")
					.setParameter("teamId", teamId).setParameter("competitionId", competitionId)
					.setParameter("seasonId", seasonId).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TeamCompetitionSeason> findByCompetition(Long competitionId) {
		return (List<TeamCompetitionSeason>) this.getEntityManager().createQuery("SELECT tcs FROM TeamCompetitionSeason tcs WHERE tcs.competitionSeason.competition.id = :competitionId "
				+ "AND tcs.competitionSeason.active = 1 "
				+ "AND tcs.active = 1 ").setParameter("competitionId", competitionId).
				getResultList();
	}

}
