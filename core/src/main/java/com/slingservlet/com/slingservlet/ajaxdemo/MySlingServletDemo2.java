package com.slingservlet.com.slingservlet.ajaxdemo;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;


@SlingServlet(paths="/bin/casestudy",methods="GET")
public class MySlingServletDemo2  extends SlingSafeMethodsServlet{

	private static final long serialVersionUID = -3989415828418879005L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "application/json");
		response.getWriter().print("Thanks for the patience, coming soon! server response");
	}
	

}
