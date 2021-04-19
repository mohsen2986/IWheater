package com.iweather.data.repository

import com.iweather.data.model.WeatherEntity
import com.iweather.domain.base.Result
import kotlinx.coroutines.flow.Flow

interface WeatherCache{

    suspend fun getWeather(): Flow<Result<WeatherEntity>>

    suspend fun setLastCacheTime()

    suspend fun isWeatherCacheExpired(): Flow<Boolean>

    suspend fun setWeather(weatherEntity: WeatherEntity)

}