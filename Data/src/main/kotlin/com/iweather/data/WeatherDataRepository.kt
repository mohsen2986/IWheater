package com.iweather.data

import com.iweather.data.mapper.WeatherMapper
import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.weather.WeatherCache
import com.iweather.data.source.weather.WeatherDataSourceFactory
import com.iweather.domain.base.DataHolder
import com.iweather.domain.base.Success
import com.iweather.domain.base.map
import com.iweather.domain.models.Weather
import com.iweather.domain.repositories.WeatherRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

class WeatherDataRepository(
    private val mapper: WeatherMapper,
    private val cache: WeatherCache,
    private val factory: WeatherDataSourceFactory
): WeatherRepository {

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    override suspend fun fetchWeatherData(placeName: String): Flow<DataHolder<Weather>> {
        return factory.
            getDataSource(cache.isWeatherCacheExpired().first() , cache.isWeatherCached().first())
            .getWeather()
            .flowOn(IO)
            .distinctUntilChanged()
            .flatMapConcat {
                println("DB: the cache expire ${cache.isWeatherCacheExpired().first()}")
                println("DB: the cache is cached ${cache.isWeatherCached().first()}")
                cache.setLastCacheTime()
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
//        return factory.getDataSource(false , false)
//            .getWeather()
//            .distinctUntilChanged()
//            .map {
//                it.map { mapper.mapFromEntity(it) }
//            }

    }



}