package com.gamaset.sonicbot.collector.dto.requestbody;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gamaset.sonicbot.collector.repository.entity.BankRoll;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.3.0
 */
public class CreatebetRequestBodyDTO {

	private BankRoll bankroll;
	
	
	
	public BankRoll getBankroll() {
		return bankroll;
	}

	public void setBankroll(BankRoll bankroll) {
		this.bankroll = bankroll;
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
