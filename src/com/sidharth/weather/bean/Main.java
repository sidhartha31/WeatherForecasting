package com.sidharth.weather.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main
{
    private String temp;
    private String temp_min;
    private String humidity;
    private String pressure;
    private String temp_max;

    @Override
    public String toString()
    {
        return "Main [temp = "+temp+", temp_min = "+temp_min+", humidity = "+humidity+", pressure = "+pressure+", temp_max = "+temp_max+"]";
    }
}