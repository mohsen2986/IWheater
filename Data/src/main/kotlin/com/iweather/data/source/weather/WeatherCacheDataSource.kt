package com.iweather.data.source.weather

import com.iweather.data.model.CityEntity
import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.weather.WeatherCache
import com.iweather.data.repository.weather.WeatherDataSource
import com.iweather.domain.base.DataHolder
import kotlinx.coroutines.flow.Flow

class WeatherCacheDataSource (
    private val weatherCache: WeatherCache
): WeatherDataSource {
    override suspend fun getWeather(): Flow<DataHolder<WeatherEntity>> =
        weatherCache.getWeather()

    override suspend fun saveWeather(weather: WeatherEntity) =
        weatherCache.setWeather(weather)

}