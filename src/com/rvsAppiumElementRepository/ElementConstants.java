package com.rvsAppiumElementRepository;

import java.io.InputStream;
import java.util.Properties;

public class ElementConstants {

	public static Properties getElements()
	{
		Properties prop = new Properties();
		InputStream input = null;
		try
		{
			input = ElementConstants.class.getResourceAsStream("elements.properties");
			prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
}
