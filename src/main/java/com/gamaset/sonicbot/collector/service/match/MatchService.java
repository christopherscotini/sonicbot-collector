package com.gamaset.sonicbot.collector.service.match;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.DoubleChanceProbabilityDTO;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetTypeEnum;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.infra.utils.MatchObjectConverter;
import com.gamaset.sonicbot.collector.repository.CouponMatchRepository;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeam;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatchTeamProbValue;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
@Service
public class MatchService {

	@Autowired
	private CouponMatchRepository matchRepository;
	
	/**
	 * Lista os jogos salvos conforme a data
	 * 
	 * @param date
	 * @return list of {@link CouponMatch}
	 */
	public List<MatchDataDTO> listByDate(String date){
		
		List<CouponMatch> couponMatches = matchRepository.findByCouponId(DateUtils.convertDateStringToTimestamp(date));
		List<MatchDataDTO> datas = new ArrayList<>();
		for (CouponMatch couponMatch : couponMatches) {
			MatchDataDTO data = MatchObjectConverter.convert(couponMatch);
			datas.add(data);
		}
		
		return datas;
	}

	private MatchResumeDTO buildMatchResume(List<CouponMatchTeam> couponMatchTeams) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
