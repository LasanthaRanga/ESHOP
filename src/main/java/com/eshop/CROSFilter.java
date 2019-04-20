package com.eshop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;



public class CROSFilter extends GenericFilterBean implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponce = (HttpServletResponse)response;
		httpResponce.setHeader("Access-Control-Allow-Origin", "*");
		httpResponce.setHeader("Access-Control-Allow-Methods", "*");
		
		httpResponce.setHeader("Access-Control-Allow-Headers", "*");
		httpResponce.setHeader("Access-Control-Allow-Credentials", "false");
		httpResponce.setHeader("Access-Control-Max-Age", "3600");
		System.out.println("--------------- CORS Confiburation completed -----------");
		chain.doFilter(request, response);
	}

}
