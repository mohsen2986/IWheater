package com.iweather.data.repository

import com.iweather.data.model.WeatherEntity
import com.iweather.domain.base.Result
import kotlinx.coroutines.flow.Flow

interface WeatherDataSource {

    suspend fun getWeather(): Flow<Result<WeatherEntity>>

    suspend fun saveWeather(weather: WeatherEntity)
}
