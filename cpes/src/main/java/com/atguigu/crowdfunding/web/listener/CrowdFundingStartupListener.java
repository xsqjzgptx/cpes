package com.atguigu.crowdfunding.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class CrowdFundingStartupListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		String contextPath = servletContext.getContextPath();
		servletContext.setAttribute("APP_PATH", contextPath);
		System.out.println(contextPath);
		super.contextInitialized(event);
	}

}
