package com.iweather.domain.usecases

import com.iweather.domain.models.Weather
import com.iweather.domain.base.DataHolder
import com.iweather.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherUsecase(
    private val weatherRepository: WeatherRepository
){
    suspend operator fun invoke(placeName: String): Flow<DataHolder<Weather>> =
        weatherRepository.fetchWeatherData(placeName)

}