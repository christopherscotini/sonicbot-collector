package com.gamaset.sonicbot.collector.service.match;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.infra.utils.MatchObjectConverter;
import com.gamaset.sonicbot.collector.repository.CouponMatchRepository;
import com.gamaset.sonicbot.collector.repository.CouponRepository;
import com.gamaset.sonicbot.collector.repository.entity.Coupon;
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
	private CouponRepository couponRepository;
	@Autowired
	private CouponMatchRepository matchRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<Coupon> coupons(){
		return couponRepository.findAll();
	}
	
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

}
