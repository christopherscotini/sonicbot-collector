package com.gamaset.sonicbot.collector.infra.exception;

public abstract class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 7665210226166879359L;

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

}
