package com.iweather.domain.usecases

import com.iweather.domain.models.Weather
import com.iweather.domain.base.Result
import com.iweather.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherUsecase(
    private val weatherRepository: WeatherRepository
){
    suspend operator fun invoke(placeName: String): Flow<Result<Weather>> =
        weatherRepository.fetchWeatherData(placeName)

}