package com.gamaset.sonicbot.collector;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Filtro para adicionar cabeçalhos de comunicação com o sistema web feito em Angular
 * 
 * @author Christopher Rozario
 * @since 0.0.1
 *
 */
@Component
public class SimpleCORSFilter implements Filter{

	//This is a better approach
	@Override
	public void destroy() {
	    // This constructor is intentionally empty, because something something
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response=(HttpServletResponse) resp;

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

		chain.doFilter(req, resp);
	}

	//This is a better approach
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	    // This constructor is intentionally empty, because something something
	}

}
