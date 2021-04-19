package com.iweather.remote.mapper

import com.iweather.data.model.WeatherEntity
import com.iweather.remote.model.CityWeatherDto

class WeatherResponseModelMapper :ModelMapper<CityWeatherDto, WeatherEntity> {

    override fun mapFromModel(model: CityWeatherDto): WeatherEntity {
        return with(model){
            WeatherEntity(model.main.temp)
        }
    }

}