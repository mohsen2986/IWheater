package com.iweather.data.source

import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.WeatherCache
import com.iweather.data.repository.WeatherDataSource
import com.iweather.domain.base.Result
import kotlinx.coroutines.flow.Flow

class WeatherCacheDataSource (
    private val weatherCache: WeatherCache
): WeatherDataSource{
    override suspend fun getWeather(): Flow<Result<WeatherEntity>> =
        weatherCache.getWeather()

    override suspend fun saveWeather(weather: WeatherEntity) =
        weatherCache.setWeather(weather)




}