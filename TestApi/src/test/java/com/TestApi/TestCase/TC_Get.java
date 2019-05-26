package com.TestApi.TestCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TestApi.Base.Base;


import io.restassured.RestAssured;
import io.restassured.http.Method;;

public class TC_Get extends Base {
	
	@BeforeClass
	
	void getAllEmployees()
	{
		logger.info("-----Started TC_1 Get-----");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		response=httpreq.request(Method.GET,"/employees");
		logger.info(response);	
	}
	
	@Test
	
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		String Headers = response.getHeaders().toString();
		logger.info(Headers);
		logger.info(""+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	
	void checkStatusCode()
	{
		int statuscode = response.getStatusCode();
		
		logger.info(""+statuscode);
		AssertJUnit.assertEquals(statuscode, 200);
	}
	
	@Test
	void checkstatusLine()
	{
		logger.info("-----Checking Status Line-----");
		
		String statusLine = response.getStatusLine();
		logger.info("Status Line is ==>" + statusLine);
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType()
	{
		logger.info("-----Checking Content Type-----");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is =>"+contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
	
	@Test
	void checkserverType()
	{
		logger.info("-----Checking Server Type-----");
		
		String serverType = response.header("Server");
		logger.info("Server type is =>"+serverType);
		Assert.assertEquals(serverType, "nginx/1.14.1");
	}
	
	@Test
	void checkcontentEncoding()
	{
		logger.info("-----Checking Content Encoding-----");
		
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content coding is =>"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}

}
