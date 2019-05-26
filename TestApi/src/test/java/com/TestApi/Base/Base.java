package com.TestApi.Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Base {
	public static RequestSpecification httpreq;
	public static Response response;
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = logger.getLogger("EmployeeRestApi");
		
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	

}
