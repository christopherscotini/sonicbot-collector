package com.gamaset.sonicbot.collector.repository;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.repository.dao.JpaGenericDao;
import com.gamaset.sonicbot.collector.repository.entity.domain.Competition;

@Component
public class CompetitionRepository extends JpaGenericDao<Competition, Long>{



}