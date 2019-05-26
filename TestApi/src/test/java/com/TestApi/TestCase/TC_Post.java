package com.TestApi.TestCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.TestApi.Base.Base;
import com.TestApi.Utility.ApiUtility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_Post extends Base{
	
	String empname = ApiUtility.empname();
	String empSal = ApiUtility.empSal();
	String empAge = ApiUtility.empAge();
	
	@Test
	void Post() throws InterruptedException
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		
		JSONObject reqparameters = new JSONObject();
		reqparameters.put("name", empname);
		reqparameters.put("Salary", empSal);
		reqparameters.put("Age", empAge);
		
		httpreq.header("Content-Type", "application/json");
		httpreq.body(reqparameters.toJSONString());
		response = httpreq.request(Method.POST,"/create");
		Thread.sleep(500);	
	}
	
	@Test
	public void checkResponsebody() throws InterruptedException
	{
		String ResponseBody = response.getBody().asString();
		logger.info("Post Message"+ResponseBody);
		Assert.assertEquals(ResponseBody.contains(empname), true);
		Assert.assertEquals(ResponseBody.contains(empSal), true);
		Assert.assertEquals(ResponseBody.contains(empAge), true);
	}
	public static String getid() throws InterruptedException
	{
		JsonPath jsonPathEvaluator = response.jsonPath();
		String empID = jsonPathEvaluator.get("id");
		System.out.println("Employee ID received from Response :"+empID);
		Thread.sleep(500);
		return(empID);		
	}
	
//@Test
//
//void checkResponseBody()
//{
//	String responseBody = response.getBody().asString();
//	String Headers = response.getHeaders().toString();
//	logger.info(Headers);
//	logger.info(""+responseBody);
//	Assert.assertTrue(responseBody!=null);
//}

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
