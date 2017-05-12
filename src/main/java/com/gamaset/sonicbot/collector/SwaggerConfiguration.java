/**
 * 
 */
package com.gamaset.sonicbot.collector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe responsável por realizar a configuração do Swagger no projeto
 * 
 * @author Christopher Rozario
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gamaset.sonicbot.collector.controller"))
				.paths(PathSelectors.any())
				.build()
				.tags(
						new Tag("TeamCompetitionSeason", "Serviços relacionado a Time Competição/Sessão"),
						new Tag("Schedule", "Serviços relacionado aos Jobs"),
						new Tag("MatchAcademia", "Serviços relacionados as partidas do academia das Apostas"),
						new Tag("Match", "Serviços relacionados as partidas salvas no bd"),
						new Tag("Coupon", "Serviços relacionados ao coupon de jogos"),
						new Tag("Bankroll", "Serviços relacionados ao bankroll de jogos"),
						new Tag("MarketBet", "Serviços relacionados aos mercado de jogo"),
						new Tag("Competition", "Serviços relacionados as competições")
				)
				.apiInfo(apiInfo());
	}
	
	/**
	 * @return Informações sobre a API
	 */
	private ApiInfo apiInfo() {
	    Contact contact = new Contact("Gamaset Consulting LTDA", null, "gamasetconsulting@gmail.com");
	    return new ApiInfo(
				"sonicbot-collector", 
				"Serviços direcionados a coleta de informações de partidas de futebol.", 
				"1.0.0", null, contact, null, null);
	}
	
}
