package com.iweather.presentation.mapper

import com.iweather.domain.models.Weather
import com.iweather.presentation.model.TemperatureData
import com.iweather.presentation.model.WeatherData

class WeatherMapper(): Mapper<WeatherData , Weather>{

    override fun mapToView(type: Weather): WeatherData {
        return with(type){
            WeatherData("" , TemperatureData(temperature) , 0)
        }
    }
}