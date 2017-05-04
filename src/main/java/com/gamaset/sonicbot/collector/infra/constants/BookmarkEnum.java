package com.gamaset.sonicbot.collector.infra.constants;

public enum BookmarkEnum {

	BET365(19);
	
	private Integer id;
	
	private BookmarkEnum(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
}
