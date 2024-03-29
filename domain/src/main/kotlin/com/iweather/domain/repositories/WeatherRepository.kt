package com.iweather.domain.repositories

import com.iweather.domain.models.Weather
import com.iweather.domain.base.DataHolder
import com.iweather.domain.models.City
import kotlinx.coroutines.flow.Flow

interface WeatherRepository{
    suspend fun fetchWeatherData(placeName: String): Flow<DataHolder<Weather>>
}