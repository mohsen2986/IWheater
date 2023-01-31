package com.iweather.domain.usecases

import com.iweather.domain.base.DataHolder
import com.iweather.domain.models.City
import com.iweather.domain.repositories.CityRepository
import com.iweather.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow

class SearchCityUseCase(
    private val cityRepository: CityRepository
){
    suspend operator fun invoke(cityName: String): Flow<DataHolder<List<City>>> =
        cityRepository.searchCity(cityName)
}