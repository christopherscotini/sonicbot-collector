package com.gamaset.sonicbot.collector.infra.exception.scrapper;

/**
 * Exceção que será responsavel por lançar erros de formato de valor na leitura do html
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
public class FormatValueScrapperException extends ScrapperException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263978926283508310L;

	public FormatValueScrapperException(String message) {
		super(">>_Format Value Error: "+message);
	}

}
