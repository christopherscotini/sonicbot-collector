package com.gamaset.sonicbot.collector.infra.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author Christopher Rozario
 *
 * @since
 */
public class CalculatorUtils {

	public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
		return dividend.divide(divisor, 2, RoundingMode.HALF_EVEN);
	}

}
