package com.gamaset.sonicbot.collector.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.infra.constants.PositionConditionEnum;

public class PositionDTO {
	private PositionConditionEnum condition;
	private Integer position;
	
	public PositionDTO() {
	}

	/**
	 * @param condition
	 * @param position
	 */
	public PositionDTO(PositionConditionEnum condition, Integer position) {
		super();
		this.condition = condition;
		this.position = position;
	}
	public PositionConditionEnum getCondition() {
		return condition;
	}
	public void setCondition(PositionConditionEnum condition) {
		this.condition = condition;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
