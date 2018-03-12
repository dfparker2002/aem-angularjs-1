package com.slingservlet.com.slingservlet.ajaxdemo;


import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.simple.JSONObject;


//this one is good, when get data from this path over $.ajax
@SlingServlet(paths="/bin/abcServlet", methods = {"GET","POST"}, metatype=false)
public class MySlingServletDemo extends SlingAllMethodsServlet {


	private static final long serialVersionUID = 6945931742882168151L;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		try{
			String id = UUID.randomUUID().toString();
	          String firstName = request.getParameter("firstName");
	          String lastName = request.getParameter("lastName");
	          
	          JSONObject obj=new JSONObject();
	          obj.put("id",id);
	          obj.put("firstname",firstName);
	          obj.put("lastname",lastName);
	          
	    
	          String jsonData = obj.toJSONString();
	          response.getWriter().write(jsonData);
	          
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		Random rand = new Random();
		try{
        	JSONObject obj=new JSONObject();
            obj.put("id",rand.nextInt(100));
            obj.put("firstname","adam");
			obj.put("lastname","cao");
			String jsonData = obj.toJSONString();
	        response.getWriter().write(jsonData);
	        
	        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
