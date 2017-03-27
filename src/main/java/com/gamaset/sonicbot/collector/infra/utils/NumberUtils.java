package com.gamaset.sonicbot.collector.infra.utils;

import org.apache.commons.lang.StringUtils;

public class NumberUtils {

	public static Integer converToInteger(String str){
		return verificaStringNulaInteger(str);
	}
	
	
	private static Integer verificaStringNulaInteger(String str) {
		if (str == null || "".equals(str)) {
			return 0;
		} else {
			return Integer.valueOf(StringUtils.trim(str));
		}
	}
	
}
