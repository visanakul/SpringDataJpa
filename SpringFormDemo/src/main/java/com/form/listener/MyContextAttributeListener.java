package com.form.listener;

import java.util.Enumeration;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Application Lifecycle Listener implementation class MyContextAttibuteListener
 *
 */

public class MyContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public MyContextAttributeListener() {
    	System.out.println("***MyContextListener***");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scab)  { 
    	System.out.println("***attributeAdded*** Name : "+scab.getName()+"---value : "+scab.getValue());
        }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scab)  { 
    	System.out.println("***attributeRemoved*** Name : "+scab.getName()+"---value : "+scab.getValue());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scab)  { 
    	System.out.println("***attributeReplaced*** Name : "+scab.getName()+"---value : "+scab.getValue());
    }
	
}
