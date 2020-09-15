package com.hk.member.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MemberFilter
 */
//얘도 url없이 web.xml에 등록해서 쓰는거얌.
public class MemberFilter implements Filter {
FilterConfig fConfig;
    /**
     * Default constructor. 
     */
    public MemberFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		request.setCharacterEncoding(fConfig.getInitParameter("encoding"));
		System.out.println("encoding은"+fConfig.getInitParameter("encoding"));
		System.out.println("Filter-doFilter()");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig=fConfig;
		System.out.println("Filter-init()");
	}

}
