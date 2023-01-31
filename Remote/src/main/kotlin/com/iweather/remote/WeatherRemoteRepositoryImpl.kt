package com.iweather.remote

import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.weather.WeatherRemote
import com.iweather.remote.service.ApiInterface
import kotlinx.coroutines.flow.Flow
import com.iweather.domain.base.*
import com.iweather.remote.mapper.ModelMapper
import com.iweather.remote.model.CityWeatherDto
import kotlinx.coroutines.flow.flow

class WeatherRemoteRepositoryImpl(
    private val service: ApiInterface,
    private val mapper: ModelMapper<CityWeatherDto, WeatherEntity> ,
    ): WeatherRemote {

    override suspend fun getWeather(): Flow<DataHolder<WeatherEntity>> {
        return flow {
            repeat(10){
                val  data = service.getWeatherByCityName()
                 emit(Success(mapper.mapFromModel(data)))
            }
        }
    }

}