package com.servoy.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class AddHeaderFilter implements Filter {

	private FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (response instanceof HttpServletResponse) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			Enumeration<String> names = this.config.getInitParameterNames();
			while(names.hasMoreElements()) {
				String headerName = names.nextElement();
				String headerValue = this.config.getInitParameter(headerName);
				httpResponse.setHeader(headerName, headerValue);
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
