package com.sidharth.weather.facade;

import com.sidharth.weather.bean.WeatherMain;

public interface WeatherForecastFacade {

	public WeatherMain invokeCurrentWeatherAPI(String cityName);
}
