package com.gamaset.sonicbot.collector.business.probabilitymatch.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.infra.utils.DateUtils;
import com.gamaset.sonicbot.collector.repository.CouponRepository;
import com.gamaset.sonicbot.collector.repository.entity.Coupon;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class CouponCreateProcessComponent {

	@Autowired
	private CouponRepository repo;
	
	/**
	 * 
	 * @param dateString
	 * @return {@link Coupon} object.
	 */
	public Coupon process(String dateString){
		long dateLong = DateUtils.convertDateStringToTimestamp(dateString);
		Coupon findById = repo.findById(dateLong);
		if(findById != null){
			return findById;
		}
		Coupon entity = new Coupon();
		entity.setDate(dateString);
		entity.setId(dateLong);
		return repo.insert(entity);
	}
	
}
