package com.gamaset.sonicbot.collector.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.CouponMatch;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
@Component
public class CouponMatchRepository extends JpaGenericDao<CouponMatch, Long>{

	public List<CouponMatch> findByCouponId(Long couponId) {
		
		List<CouponMatch> resultList = getEntityManager().createQuery("FROM CouponMatch cm WHERE cm.coupon.id = :couponId", CouponMatch.class).setParameter("couponId", couponId).getResultList();
		
		return resultList;
	}


}