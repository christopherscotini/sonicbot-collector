package com.gamaset.sonicbot.collector.infra.exception;

public class NoDataFoundException extends BusinessException {

	private static final long serialVersionUID = 5077420954080626074L;

	public NoDataFoundException(String registro) {
		super("No Data Found: "+registro );		
	}
}
