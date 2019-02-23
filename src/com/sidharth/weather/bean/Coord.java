package com.sidharth.weather.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coord
{
    private String lon;
    private String lat;

    @Override
    public String toString()
    {
        return "Coord [lon = "+lon+", lat = "+lat+"]";
    }
}