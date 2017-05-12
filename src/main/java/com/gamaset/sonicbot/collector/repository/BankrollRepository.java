package com.gamaset.sonicbot.collector.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.BetBankRoll;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
@Component
public class BankrollRepository extends JpaGenericDao<BetBankRoll, Long> {

	@Override
	public List<BetBankRoll> findAll() {
		return getEntityManager().createQuery("FROM BetBankRoll b ORDER BY b.date desc").getResultList();
	}

}