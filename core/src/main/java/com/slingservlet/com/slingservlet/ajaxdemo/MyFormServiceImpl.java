package com.slingservlet.com.slingservlet.ajaxdemo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class MyFormServiceImpl implements MyFormService{

	@Override
	public String submitdata(String v1, String v2) {
		System.out.println(v1 +"  :  " +v2);
		return "your name is "+v1+"  :    "+v2;
	}

}
