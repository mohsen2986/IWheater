package com.iweather.data

import com.iweather.data.mapper.WeatherMapper
import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.WeatherCache
import com.iweather.data.source.WeatherDataSourceFactory
import com.iweather.domain.base.Result
import com.iweather.domain.base.Success
import com.iweather.domain.base.map
import com.iweather.domain.models.Weather
import com.iweather.domain.repositories.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

class WeatherDataRepository(
        private val mapper: WeatherMapper ,
        private val cache: WeatherCache ,
        private val factory: WeatherDataSourceFactory
): WeatherRepository {

    @FlowPreview
    @ExperimentalCoroutinesApi
    override suspend fun fetchWeatherData(placeName: String): Flow<Result<Weather>> {
        return factory.
            getDataSource(cache.isWeatherCacheExpired().first() , cache.isWeatherCacheExpired().first())
            .getWeather()
            .distinctUntilChanged()
            .flatMapConcat {
                factory.getCacheDataSource().saveWeather(
                    when(it){
                        is Success -> it.data
                        else -> WeatherEntity(0.0)
                    }
                )
                factory.getCacheDataSource().getWeather()
            }
            .map {
                it.map { mapper.mapFromEntity(it) }
            }

    }

}