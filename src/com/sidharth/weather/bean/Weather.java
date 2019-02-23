package com.sidharth.weather.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather
{
    private String icon;
    private String description;
    private String main;
    private String id;

    @Override
    public String toString()
    {
        return "Weather [icon = "+icon+", description = "+description+", main = "+main+", id = "+id+"]";
    }
}