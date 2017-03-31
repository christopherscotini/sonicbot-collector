package com.gamaset.sonicbot.collector.infra.exception;

public class DataEntryInvalidException extends BusinessException {

	private static final long serialVersionUID = 8705252009811865635L;

	public DataEntryInvalidException(String campo) {
		super(String.format("field %s invalid.", campo));
	}
	
}
