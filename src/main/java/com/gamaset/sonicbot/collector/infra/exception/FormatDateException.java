package com.gamaset.sonicbot.collector.infra.exception;

/**
 * Exceção que será responsavel por lançar erros de formato de valor na leitura do html
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class FormatDateException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263978926283508310L;

	public FormatDateException(String message) {
		super(">>_Format Date Error: "+message);
	}

}
