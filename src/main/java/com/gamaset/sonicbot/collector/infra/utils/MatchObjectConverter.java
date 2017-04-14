package com.gamaset.sonicbot.collector.infra.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.DoubleChanceProbabilityDTO;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetTypeEnum;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeam;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeamProbValue;

public class MatchObjectConverter {

	public static MatchDataDTO convert(CouponMatch couponMatch) {

		return null;
	}

	private MatchStatisticDTO buildMatchstatistics(List<CouponMatchTeam> couponMatchTeams) {
		return new MatchStatisticDTO(buildMatchstatisticsTeam(couponMatchTeams.get(0)), buildMatchstatisticsTeam(couponMatchTeams.get(1)));
	}

	private TeamStatisticsDTO buildMatchstatisticsTeam(CouponMatchTeam couponMatchTeam) {
		TeamStatisticsDTO dto = new TeamStatisticsDTO();
		
		List<CouponMatchTeamProbValue> valuesDC = couponMatchTeam.getCouponMatchTeamProbValues().stream().
		filter(value -> value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.HOME_TEAM_OR_DRAW.getId()) 
				|| value.getSelectionMarketBet().getId().equals(SelectionMarketBetTypeEnum.AWAY_TEAM_WIN.getId())).
		collect(Collectors.toList());
		
		List<DoubleChanceProbabilityDTO> dcDtos = new ArrayList<>();
//		valuesDC.forEach(dc -> dcDtos.add());
		dto.setDoubleChanceProbabilities(dcDtos);
		
		return dto;
	}
	
}
