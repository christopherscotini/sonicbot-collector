package com.gamaset.sonicbot.collector.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.BankRoll;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
@Component
public class BankrollRepository extends JpaGenericDao<BankRoll, Long> {

	@Override
	public List<BankRoll> findAll() {
		return getEntityManager().createQuery("FROM BankRoll b ORDER BY b.date desc").getResultList();
	}

}