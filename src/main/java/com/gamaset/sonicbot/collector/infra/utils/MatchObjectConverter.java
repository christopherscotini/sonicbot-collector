package com.gamaset.sonicbot.collector.infra.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.TeamDTO;
import com.gamaset.sonicbot.collector.dto.TeamMatchDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.DoubleChanceProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.FulltimeProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.GoalProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.StatsMarketDTO;
import com.gamaset.sonicbot.collector.infra.ObjectsConverter;
import com.gamaset.sonicbot.collector.infra.constants.CriteriaAnalisysMatchesTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GeneralOrConditionTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalMarketTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.GoalTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetTypeEnum;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeam;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeamProbValue;
import com.gamaset.sonicbot.collector.repository.entity.domain.Team;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class MatchObjectConverter {

	public static MatchDataDTO convert(CouponMatch couponMatch) {
		return new MatchDataDTO(buildMatchResume(couponMatch), buildMatchstatistics(couponMatch.getCouponMatchTeams()));
	}

	private static MatchResumeDTO buildMatchResume(CouponMatch couponMatch) {
		MatchResumeDTO dto = new MatchResumeDTO();
		dto.setHomeTeamMatch(buildTeamMatch(couponMatch.getHomeTeam().getTeam(), couponMatch.getScoreHomeTeam()));
		dto.setAwayTeamMatch(buildTeamMatch(couponMatch.getAwayTeam().getTeam(), couponMatch.getScoreAwayTeam()));
		dto.setCompetitionSeason(ObjectsConverter.convert(couponMatch.getHomeTeam().getCompetitionSeason()));
		dto.setDate(couponMatch.getMatchDate());
		dto.setLinkMatch(couponMatch.getUrlMatch());
		dto.setMatchId(couponMatch.getId());
		dto.setMatchStatus(couponMatch.getMatchStatus());
		return dto;
	}


	private static TeamMatchDTO buildTeamMatch(Team team, Integer score) {
		TeamMatchDTO dto = new TeamMatchDTO();
		dto.setScore(score);
		dto.setTeam(new TeamDTO(team.getId(), team.getName(), team.getCountry()));
		return dto;
	}

	private static MatchStatisticDTO buildMatchstatistics(List<CouponMatchTeam> couponMatchTeams) {
		TeamStatisticsDTO statsHome = buildMatchstatisticsTeam(couponMatchTeams.get(0));
		TeamStatisticsDTO statsAway = buildMatchstatisticsTeam(couponMatchTeams.get(1));
		return new MatchStatisticDTO(statsHome, statsAway);
	}

	private static TeamStatisticsDTO buildMatchstatisticsTeam(CouponMatchTeam couponMatchTeam) {
		TeamStatisticsDTO dto = new TeamStatisticsDTO();
		
		List<DoubleChanceProbabilityDTO> dcDtos = new ArrayList<>();
		couponMatchTeam.getCouponMatchTeamProbValues().stream().
				filter(value -> value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.HOME_TEAM_OR_DRAW.getId()) 
						|| value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.DRAW_OR_AWAY_TEAM.getId())).
				collect(Collectors.toList()).forEach(dc -> dcDtos.add(buildDoubleChanceProbDTO(dc)));
		dto.setDoubleChanceProbabilities(dcDtos);
		
		List<FulltimeProbabilityDTO> ftDtos = new ArrayList<>();
		couponMatchTeam.getCouponMatchTeamProbValues().stream().
		filter(value -> value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.HOME_TEAM_WIN.getId()) 
				|| value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.AWAY_TEAM_WIN.getId())).
		collect(Collectors.toList()).forEach(dc -> ftDtos.add(buildFulltimeProbDTO(dc)));
		dto.setFulltimeProbabilities(ftDtos);

		List<GoalProbabilityDTO> goalsDtos = new ArrayList<>();
		couponMatchTeam.getCouponMatchTeamProbValues().stream().
		filter(value -> value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.OVER_05.getId()) 
				|| value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.OVER_15.getId())).
		collect(Collectors.toList()).forEach(dc -> goalsDtos.add(buildGoalsProbDTO(dc)));
		dto.setGoalsProbabilities(goalsDtos);

		
		return dto;
	}

	private static GoalProbabilityDTO buildGoalsProbDTO(CouponMatchTeamProbValue goal) {
		GoalProbabilityDTO dto = new GoalProbabilityDTO(GeneralOrConditionTypeEnum.findById(goal.getTypeGeneralCondition().getId()),
				buildGoalTypeEnum(goal), 
				GoalTypeEnum.findById(goal.getCouponMatchTeamProbValueGoal().getGoalType().getId()), 
				CriteriaAnalisysMatchesTypeEnum.findById(goal.getTypeCriteriaAnalisysMatch().getId()));
		dto.getProbability().setSelectionMarketBetId(goal.getSelectionMarketBet().getId());
		dto.getProbability().setSize(goal.getSize());
		dto.getProbability().setValue(goal.getValue());
		return dto;
	}

	private static GoalMarketTypeEnum buildGoalTypeEnum(CouponMatchTeamProbValue goal) {
		if(SelectionMarketBetTypeEnum.findById(goal.getSelectionMarketBet().getId()).equals(SelectionMarketBetTypeEnum.OVER_05)){
			return GoalMarketTypeEnum.OVER_05;
		}
		if(SelectionMarketBetTypeEnum.findById(goal.getSelectionMarketBet().getId()).equals(SelectionMarketBetTypeEnum.OVER_15)){
			return GoalMarketTypeEnum.OVER_15;
		}
		
		return null;
	}

	private static FulltimeProbabilityDTO buildFulltimeProbDTO(CouponMatchTeamProbValue dc) {
		FulltimeProbabilityDTO dto = new FulltimeProbabilityDTO(CriteriaAnalisysMatchesTypeEnum.findById(dc.getTypeCriteriaAnalisysMatch().getId()));
		dto.setStats(buildStatsDTO(dc));
		return dto;
	}

	private static DoubleChanceProbabilityDTO buildDoubleChanceProbDTO(CouponMatchTeamProbValue dc) {
		DoubleChanceProbabilityDTO dto = new DoubleChanceProbabilityDTO(CriteriaAnalisysMatchesTypeEnum.findById(dc.getTypeCriteriaAnalisysMatch().getId()));
		dto.setStats(buildStatsDTO(dc));
		return dto;
	}

	private static StatsMarketDTO buildStatsDTO(CouponMatchTeamProbValue stats) {
		StatsMarketDTO dto = new StatsMarketDTO();
		dto.setSelectionMarketBetId(stats.getSelectionMarketBet().getId());
		dto.setSize(stats.getSize());
		dto.setValue(stats.getValue());
		return dto;
	}
	
}
