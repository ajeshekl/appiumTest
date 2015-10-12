package com.rvsAppiumTestData;

import java.io.InputStream;
import java.util.Properties;

public class TestDataConstants {

	public static Properties getTestData()
	{
		Properties prop = new Properties();
		InputStream input = null;
		try
		{
			input = TestDataConstants.class.getResourceAsStream("testdata.properties");
			prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
}
