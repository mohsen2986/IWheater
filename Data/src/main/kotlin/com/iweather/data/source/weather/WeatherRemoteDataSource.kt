package com.iweather.data.source.weather

import com.iweather.data.model.CityEntity
import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.weather.WeatherDataSource
import com.iweather.data.repository.weather.WeatherRemote
import com.iweather.domain.base.DataHolder
import kotlinx.coroutines.flow.Flow

class WeatherRemoteDataSource(
        private val weatherRemote: WeatherRemote
): WeatherDataSource {

    override suspend fun getWeather(): Flow<DataHolder<WeatherEntity>> {
        return weatherRemote.getWeather()
    }

    override suspend fun saveWeather(weather: WeatherEntity) {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

}