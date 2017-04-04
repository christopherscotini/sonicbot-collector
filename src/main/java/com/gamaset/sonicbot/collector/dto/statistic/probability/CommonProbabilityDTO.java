package com.gamaset.sonicbot.collector.dto.statistic.probability;

import com.gamaset.sonicbot.collector.infra.constants.CriteriaNumberMatchesType;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
public abstract class CommonProbabilityDTO {

	private CriteriaNumberMatchesType numberMatchesType;
	private StatsMarketDTO stats;
	
	/**
	 * @param numberMatchesType
	 */
	public CommonProbabilityDTO(CriteriaNumberMatchesType numberMatchesType) {
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
	public CriteriaNumberMatchesType getNumberMatchesType() {
		return numberMatchesType;
	}
	
	
}
