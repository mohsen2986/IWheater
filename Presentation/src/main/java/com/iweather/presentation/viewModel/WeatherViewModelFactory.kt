package com.iweather.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iweather.domain.usecases.SearchCityUseCase
import com.iweather.domain.usecases.WeatherUsecase
import com.iweather.presentation.mapper.WeatherMapper

class WeatherViewModelFactory(
    private val weatherUsecase: WeatherUsecase ,
    private val searchCityUseCase: SearchCityUseCase ,
    private val mapper: WeatherMapper
): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherUsecase , searchCityUseCase , mapper) as T
    }
}