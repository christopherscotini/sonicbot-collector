/**
 * 
 */
package com.gamaset.sonicbot.collector.dto;

/**
 *
 *
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public enum MatchStatusEnum {

	ADIADO("Adiado"),
	AGUARDANDO(""),
	EM_ANDAMENTO("Em andamento"),
	CANCELADO("Cancelado"),
	TERMINADO("Terminado");
	
	private String descriptionStatus;

	
	private MatchStatusEnum(String descriptionStatus) {
		this.descriptionStatus = descriptionStatus;
	}

	public String getDescriptionStatus() {
		return descriptionStatus;
	}
	
}
