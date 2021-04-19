package com.iweather.domain.repositories

import com.iweather.domain.models.Weather
import com.iweather.domain.base.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepository{
    suspend fun fetchWeatherData(placeName: String): Flow<Result<Weather>>
}