package com.sidharth.weather.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.sidharth.weather.constant.CommonConstants;

@Component
public class WeatherForecastUtil {

	public static final String PROPERTY_FILE = "/application.properties";
	
	public String getProperty(String key) {
		Properties prop = new Properties();
		InputStream input = null;
		String value = "";
		
		try {
			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_FILE);
			prop.load(input);
			value = prop.getProperty(key);
			return value;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getGMTDate(String unixSeconds) {
		
		long seconds = Long.parseLong(unixSeconds);
		Date date = new java.util.Date(seconds*1000L);
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-YY HH:mm:ss");
		sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+0")); 
		String formattedDate = sdf.format(date);
		
		return formattedDate;
	}

	public String getCurrentWeatherURI(String cityName) {

		String baseURI = getProperty(CommonConstants.WEATHER_API_BASE_URI);
		String apiKey = getProperty(CommonConstants.WEATHER_API_KEY);
		String currentWeatherURI = baseURI + "?q=" + cityName + "&appid=" + apiKey + "&units=metric";

		return currentWeatherURI;
	}
}
