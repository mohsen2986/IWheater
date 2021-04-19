package com.iweather.remote

import com.iweather.data.model.WeatherEntity
import com.iweather.data.repository.WeatherRemote
import com.iweather.remote.mapper.ModelMapper
import com.iweather.remote.mapper.WeatherResponseModelMapper
import com.iweather.remote.service.ApiInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import com.iweather.domain.base.*
import kotlinx.coroutines.flow.flow

class WeatherRemoteRepositoryImpl(
    private val service: ApiInterface,
    private val mapper: WeatherResponseModelMapper
    ): WeatherRemote{

    override suspend fun getWeather(): Flow<Result<WeatherEntity>> {
        return flow {
            repeat(10){
                val  data = service.getWeatherByCityName()
                 emit(Success(mapper.mapFromModel(data)))
            }
        }
    }

}