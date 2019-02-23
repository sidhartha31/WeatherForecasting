package com.sidharth.weather.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clouds
{
    private String all;

    @Override
    public String toString()
    {
        return "Clouds [all = "+all+"]";
    }
}