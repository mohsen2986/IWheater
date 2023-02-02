package com.iweather.domain.usecases

import com.iweather.domain.models.City
import com.iweather.domain.repositories.CityRepository

class AddCityToListUseCase(
    private val cityRepository: CityRepository
) {
    suspend operator fun invoke(city: City){
        cityRepository.addCityToList(city)
    }
}