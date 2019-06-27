package com.form.listener;

import java.util.Enumeration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyServletRequestListener implements ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public MyServletRequestListener() {
		System.out.println("***MyServletRequestListener***");
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		String servletName = request.getRequestURI();
		System.out.println("***requestDestroyed***" + sre + "  URI : " + servletName);
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		String servletName = request.getRequestURI();
		System.out.println("***requestInitialized***" + sre + "  URI : " + servletName);
	}

}
