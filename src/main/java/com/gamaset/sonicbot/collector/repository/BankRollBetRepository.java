package com.gamaset.sonicbot.collector.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.BankRollBet;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
@Component
public class BankRollBetRepository extends JpaGenericDao<BankRollBet, Long> {

	@Override
	public BankRollBet insert(BankRollBet entity) {
		entity.setCreatedDate(new Date());
		entity.setUpdatedDate(new Date());
		return super.insert(entity);
	}
	
	@Override
	public BankRollBet update(BankRollBet entity) {
		entity.setUpdatedDate(new Date());
		return super.update(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BankRollBet> findAll() {
		return getEntityManager().createQuery("FROM BankRollBet b ORDER BY b.updatedDate desc").getResultList();
	}

}