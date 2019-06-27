package com.form.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
       System.out.println("***MyFilter***");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("***MyFilter destroy()***");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("***MyFilter preprocess()***");
		chain.doFilter(request, response);
		System.out.println("***MyFilter postprocess()***");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("***MyFilter init()***");
	}

}
