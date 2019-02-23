package com.sidharth.weather.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sys
{
    private String country;
    private String sunrise;
    private String sunset;
    private String id;
    private String type;
    private String message;

    @Override
    public String toString()
    {
        return "Sys [country = "+country+", sunrise = "+sunrise+", sunset = "+sunset+", id = "+id+", type = "+type+", message = "+message+"]";
    }
}