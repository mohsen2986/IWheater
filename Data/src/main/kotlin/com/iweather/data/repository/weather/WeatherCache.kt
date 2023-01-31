package com.iweather.data.repository.weather

import com.iweather.data.model.WeatherEntity
import com.iweather.domain.base.DataHolder
import kotlinx.coroutines.flow.Flow

interface WeatherCache{

    suspend fun getWeather(): Flow<DataHolder<WeatherEntity>>

    suspend fun setLastCacheTime()

    suspend fun isWeatherCacheExpired(): Flow<Boolean>

    suspend fun setWeather(weatherEntity: WeatherEntity)

    suspend fun isWeatherCached(): Flow<Boolean>

}