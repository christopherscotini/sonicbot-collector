package com.gamaset.sonicbot.collector.schedule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.business.probabilitymatch.ManagerProcessProbabilityMatchSchedule;
import com.gamaset.sonicbot.collector.infra.utils.DateUtils;

/**
 * Schedule que será responsavel por ler e atualizar os jogos no banco de dados
 * 
 * @author Christopher Rozario
 *
 * @since
 */
@Component
public class ReadMatchesSchedule {

	private static final Logger LOG = LogManager.getLogger(ReadMatchesSchedule.class);
	
	// ler as 03:00:00 
	private static final String CRON_CONFIG_STATS_MATCHES = "00 25 03 * * ?";
	// ler as 02:30:00 
	private static final String CRON_CONFIG_UPDATE_MATCHES = "00 30 02 * * ?";

	@Autowired
	private ManagerProcessProbabilityMatchSchedule probabilityMatch;

	private String date;
	
	/**
	 * Responsavel por executar a leitura dos jogos e das estatisticas e salvar no banco de dados
	 * Caso o @param date venha {@value null} a data default será o dia atual -1 dia
	 * 
	 * @param date
	 */
	@Scheduled(cron = CRON_CONFIG_STATS_MATCHES, zone=DateUtils.ZONE_CONFIG_SP)
	public void executeReadMatchesAndPersist() {
		
		if(Objects.isNull(date)){
			LOG.info(String.format("%n=== before Objects.isNull [%s] ===", date));
			date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
			LOG.info(String.format("%n=== after Objects.isNull [%s] ===", date));
		}

		LOG.info(String.format("%n=== initializing read and save matches [%s] in [%s] ===", date, DateUtils.getNowDateTImeFormatted()));
		
		probabilityMatch.save(probabilityMatch.read(date));
		
		LOG.info(String.format("%n=== finished read and save matches [%s] in [%s] ===", date, DateUtils.getNowDateTImeFormatted()));
	}
	
	/**
	 * 
	 * @param date
	 */
	@Scheduled(cron = CRON_CONFIG_UPDATE_MATCHES, zone=DateUtils.ZONE_CONFIG_SP)
	public void executeReadMatchesAndUpdateResults() {
		
		if(Objects.isNull(date)){
			date = DateUtils.getDateStringTodayMinus1Day();
		}
		
		LOG.info(String.format("%n=== initializing read and update matches results [%s] in [%s] ===", date, DateUtils.getNowDateTImeFormatted()));
		
		probabilityMatch.update(date);
		
		LOG.info(String.format("%n=== finished read and update matches [%s] in [%s] ===", date, DateUtils.getNowDateTImeFormatted()));
	}
	
	/**
	 * Metodo servirá para testar os schedules via serviço
	 * @param date
	 */
	public void executeSave(String date){
		this.date = date;
		executeReadMatchesAndPersist();
		this.date = null;
	}

	/**
	 * Metodo servirá para testar os schedules via serviço
	 * @param date
	 */
	public void executeUpdate(String date){
		this.date = date;
		executeReadMatchesAndUpdateResults();
		this.date = null;
	}
}

