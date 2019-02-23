package com.sidharth.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sidharth.weather.bean.WeatherMain;
import com.sidharth.weather.service.WeatherForecastService;

@RestController
public class WeatherController {

	@Autowired
	WeatherForecastService weatherForecastService;
	
	@PostMapping("/weatherForecast.do")
	public ModelAndView getWeatherForecastDetails(@RequestParam("cityName") String cityName) {
		
		WeatherMain weatherMain = new WeatherMain();
		weatherMain = weatherForecastService.invokeCurrentWeatherAPI(cityName);
		
		ModelAndView mav = new ModelAndView();
		
		if(weatherMain == null) {
			mav.addObject("currentWeather", null);
			mav.addObject("error", "Error While Connecting to Web Service!");
			mav.setViewName("error.jsp");
		}
		else {
			mav.addObject("currentWeather", weatherMain);
			mav.setViewName("homepage.jsp");
		}
		
		return mav;
	}
	
	@PostMapping("/test.do")
	public ModelAndView testHello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testMessage", "Testing Successful!");
		mav.setViewName("homepage.jsp");
		return mav;
	}
}
