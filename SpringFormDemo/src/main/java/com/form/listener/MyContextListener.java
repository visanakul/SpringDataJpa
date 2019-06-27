package com.form.listener;

import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {

	public MyContextListener() {
		System.out.println("***MyContextListener***");
	}
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("***contextInitialized***" + sce.toString());
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("***contextDestroyed***" + sce.toString());
	}

}
