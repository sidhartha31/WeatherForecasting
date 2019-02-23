package com.sidharth.weather.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sidharth.weather.bean.WeatherMain;
import com.sidharth.weather.constant.CommonConstants;
import com.sidharth.weather.util.WeatherForecastUtil;

@Component
public class WeatherForecastService {

	@Autowired
	WeatherForecastUtil weatherUtil;

	public WeatherMain invokeCurrentWeatherAPI(String cityName) {

		try {
			String currentWeatherURI = weatherUtil.getCurrentWeatherURI(cityName);
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(currentWeatherURI);
			post.addHeader(CommonConstants.CONTENT_TYPE, "application/json");

			HttpResponse response = client.execute(post);
			String resposeString = EntityUtils.toString(response.getEntity());
			WeatherMain weatherMain = new Gson().fromJson(resposeString, WeatherMain.class);
			String sunriseTime = weatherUtil.getGMTDate(weatherMain.getSys().getSunrise());
			String sunsetTime = weatherUtil.getGMTDate(weatherMain.getSys().getSunset());
			weatherMain.getSys().setSunrise(sunriseTime);
			weatherMain.getSys().setSunset(sunsetTime);
			System.out.println(weatherMain.toString());
			return weatherMain;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
