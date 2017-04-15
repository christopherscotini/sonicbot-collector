package com.gamaset.sonicbot.collector.service.academia.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

/**
 * Componente que gerencia o login no academia das apostas
 *
 * 
 * @author Christopher Rozario
 *
 * @since 0.0.1
 *
 */
@Component
public class LoginAcademiaService {

	private static final Logger LOG = LogManager.getLogger(LoginAcademiaService.class);

	// URL found in form's action attribute
	private final String URL_ACADEMIA = "https://www.academiadasapostas.com/";
	private final String URL_ACADEMIA_LOGIN = "https://www.academiadasapostas.com/users/login_modal";

	private Map<String, String> cookies;
	
	public Map<String, String> getCookies() {
		if(cookies==null){
			this.login();
		}
		return cookies;
	}

	public void resetCookie(){
		this.cookies = null;
	}
	
	private void login() {
		try {
			
			Map<String, String> dataParams = new HashMap<String, String>();
			dataParams.put("user", "christopherscotini@hotmail.com");
			dataParams.put("passwrd", "ctr376797");
			dataParams.put("btnLogin", "Entrar");
			
			Connection.Response loginForm = 
					Jsoup.connect(URL_ACADEMIA).
					method(Connection.Method.GET).
					execute();

			String resultLogin = Jsoup.connect(URL_ACADEMIA_LOGIN).
					ignoreContentType(true).
					followRedirects(true).
					data(dataParams).
					cookies(loginForm.cookies()).
					post().
					select("body").text();
			
			this.cookies = loginForm.cookies();

			LOG.info(String.format("%n===== LOGIN: %s CACHE: %s =====", resultLogin, cookies));
			
		} catch (IOException e) {
			this.cookies = null;
			e.printStackTrace();
		}

	}

}
