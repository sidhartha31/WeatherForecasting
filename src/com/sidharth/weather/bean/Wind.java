package com.sidharth.weather.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wind
{
    private String deg;
    private String speed;

    @Override
    public String toString()
    {
        return "Wind [deg = "+deg+", speed = "+speed+"]";
    }
}