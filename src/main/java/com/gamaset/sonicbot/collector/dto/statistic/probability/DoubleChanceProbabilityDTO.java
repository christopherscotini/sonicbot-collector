package com.gamaset.sonicbot.collector.dto.statistic.probability;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.infra.constants.CriteriaNumberMatchesType;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class DoubleChanceProbabilityDTO extends CommonProbabilityDTO{

	/**
	 * 
	 * @param numberMatchesType {@link CriteriaNumberMatchesType}
	 */
	public DoubleChanceProbabilityDTO(CriteriaNumberMatchesType numberMatchesType) {
		super(numberMatchesType);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
