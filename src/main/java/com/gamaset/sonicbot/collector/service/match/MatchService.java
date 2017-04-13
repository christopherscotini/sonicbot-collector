package com.gamaset.sonicbot.collector.service.match;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.repository.CouponMatchRepository;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;

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
	public List<CouponMatch> listByDate(String date){
		
		List<CouponMatch> findByCouponId = matchRepository.findByCouponId(DateUtils.convertDateStringToTimestamp(date));
		
		return null;
	}
	
}
