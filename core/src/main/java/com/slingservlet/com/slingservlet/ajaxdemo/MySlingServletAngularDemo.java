package com.slingservlet.com.slingservlet.ajaxdemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


//this one is good, when get data from this path over $.ajax
@SlingServlet(paths="/bin/angularServlet", methods = {"GET","POST"}, metatype=false)
public class MySlingServletAngularDemo extends SlingAllMethodsServlet {


	private static final long serialVersionUID = -3997617805439132027L;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		try{
			String id = UUID.randomUUID().toString();
			//due to from request just pass string, can't pass json object
			//even you pass json, it's string json, if use json-simple convert to json , it can be responsed
			//so better use gson to convert string to json, then add uuid to object, at the end call toString method
			//and use response to 
			BufferedReader br = new BufferedReader(new  InputStreamReader(request.getInputStream()));
			String strjson = br.readLine();
			JsonParser jsonParser = new JsonParser();
			JsonObject objectFromString = jsonParser.parse(strjson).getAsJsonObject();
			objectFromString.remove("id");
			objectFromString.addProperty("id", id);
//			StringBuilder sb = new StringBuilder();
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				sb.append(line);
//			}
			
//			
//			JSONObject json = (JSONObject) new JSONParser().parse(sb.toString());
			//JSONParser parser = new JSONParser();
			//JSONObject json =  (JSONObject) parser.parse(strjson);

			
//			 String firstName = request.getParameter("firstName");
//	          String lastName = request.getParameter("lastName");
//	          
//	          JSONObject obj=new JSONObject();
//	          obj.put("id",id);
//	          obj.put("firstname",firstName);
//	          obj.put("lastname",lastName);
//	          
//	    
//	          String jsonData = obj.toJSONString();
	          
	          response.getWriter().write(objectFromString.toString());
	          
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
            obj.put("firstname","newadam");
			obj.put("lastname","newcao");
			String jsonData = obj.toJSONString();
	        response.getWriter().write(jsonData);
	        
	        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
