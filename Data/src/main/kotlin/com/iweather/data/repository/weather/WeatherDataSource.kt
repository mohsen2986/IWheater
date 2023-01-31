package com.iweather.data.repository.weather

import com.iweather.data.model.CityEntity
import com.iweather.data.model.WeatherEntity
import com.iweather.domain.base.DataHolder
import kotlinx.coroutines.flow.Flow

interface WeatherDataSource {

    suspend fun getWeather(): Flow<DataHolder<WeatherEntity>>

    suspend fun saveWeather(weather: WeatherEntity)
}
