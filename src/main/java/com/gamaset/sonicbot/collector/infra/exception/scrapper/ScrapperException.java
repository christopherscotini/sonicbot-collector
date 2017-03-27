package com.gamaset.sonicbot.collector.infra.exception.scrapper;

public abstract class ScrapperException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5124751767951697284L;

	public ScrapperException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScrapperException(String message) {
		super(message);
	}

}
