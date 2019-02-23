package com.sidharth.weather.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherMain
{
    private String dt;
    private Coord coord;
    private String visibility;
    private List<Weather> weather;
    private String name;
    private String cod;
    private Main main;
    private Clouds clouds;
    private String id;
    private Sys sys;
    private String base;
    private Wind wind;

    @Override
    public String toString()
    {
        return "WeatherMain [dt = "+dt+", coord = "+coord+", visibility = "+visibility+", weather = "+weather+", name = "+name+", cod = "+cod+", main = "+main+", clouds = "+clouds+", id = "+id+", sys = "+sys+", base = "+base+", wind = "+wind+"]";
    }
}