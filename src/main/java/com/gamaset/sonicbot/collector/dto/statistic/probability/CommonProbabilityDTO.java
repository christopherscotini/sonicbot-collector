package com.gamaset.sonicbot.collector.dto.statistic.probability;

import com.gamaset.sonicbot.collector.infra.constants.CriteriaAnalisysMatchesTypeEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
public abstract class CommonProbabilityDTO {

	private CriteriaAnalisysMatchesTypeEnum numberMatchesType;
	private StatsMarketDTO stats;
	
	/**
	 * @param numberMatchesType
	 */
	public CommonProbabilityDTO(CriteriaAnalisysMatchesTypeEnum numberMatchesType) {
		this.numberMatchesType = numberMatchesType;
	}

	/**
	 * @return the stats
	 */
	public StatsMarketDTO getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(StatsMarketDTO stats) {
		this.stats = stats;
	}

	/**
	 * @return the numberMatchesType
	 */
	public CriteriaAnalisysMatchesTypeEnum getNumberMatchesType() {
		return numberMatchesType;
	}
	
	
}
