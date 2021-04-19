package com.iweather.cache.mapper

import com.iweather.cache.model.CachedWeather
import com.iweather.data.model.WeatherEntity

class CachedWeatherMapper(
):CacheMapper<CachedWeather , WeatherEntity>{

    override fun mapFromCached(type: CachedWeather): WeatherEntity =
        WeatherEntity(type.temp)

    override fun mapToCached(type: WeatherEntity): CachedWeather =
        CachedWeather(type.temperature)

}