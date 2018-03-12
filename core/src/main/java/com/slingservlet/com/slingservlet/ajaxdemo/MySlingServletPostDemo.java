package com.slingservlet.com.slingservlet.ajaxdemo;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.simple.JSONObject;



@SlingServlet(	paths="/xiao/bonsai",
				methods ={"GET","POST"},
				metatype=false)
public class MySlingServletPostDemo extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 4244459827660970331L;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post method is colled .....");
		try{
			String id = UUID.randomUUID().toString();
	          String firstName = request.getParameter("firstName");
	          String lastName = request.getParameter("lastName");
	          
	          JSONObject obj=new JSONObject();
	          obj.put("id",id);
          	  obj.put("firstname",firstName);
          	  obj.put("lastname",lastName);
	          
	          String jsonData = obj.toString();
//	          response.getWriter().write(jsonData.toString());
	        response.setHeader("Content-Type", "application/json");
	  		response.getWriter().write("hello java servlet ..2. ");
	          
		}catch(Exception e){
//			response.getWriter().write("hello java servlet ..1. ");
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		try {
        	JSONObject obj=new JSONObject();
            obj.put("id","123456");
            obj.put("firstname","xiao2020");
			obj.put("lastname","cao");
			String jsonData = obj.toString();
			
	        response.getWriter().write(jsonData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
