package com.TestApi.Utility;

import org.apache.commons.lang3.RandomStringUtils;

public class ApiUtility {
	
	public static String empname()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return("abc"+generatedString);
	}
	
	public static String empSal()
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return(generatedString);
	}
	
	public static String empAge()
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return(generatedString);
	}
	
}
