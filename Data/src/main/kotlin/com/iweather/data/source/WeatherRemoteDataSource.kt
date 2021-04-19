package com.iweather.data.source

import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.WeatherDataSource
import com.iweather.data.repository.WeatherRemote
import com.iweather.domain.base.Result
import kotlinx.coroutines.flow.Flow

class WeatherRemoteDataSource(
        private val weatherRemote: WeatherRemote
): WeatherDataSource{

    override suspend fun getWeather(): Flow<Result<WeatherEntity>> {
        return weatherRemote.getWeather()
    }

    override suspend fun saveWeather(weather: WeatherEntity) {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

}