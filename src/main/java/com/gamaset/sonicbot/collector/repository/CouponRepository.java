package com.gamaset.sonicbot.collector.repository;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.Coupon;

@Component
public class CouponRepository extends JpaGenericDao<Coupon, Long>{


}