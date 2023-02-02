package com.iweather.presentation.viewModel.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iweather.domain.usecases.SearchCityUseCase
import com.iweather.domain.usecases.WeatherUsecase
import com.iweather.presentation.mapper.WeatherMapper

class WeatherViewModelFactory(
    private val weatherUsecase: WeatherUsecase ,
    private val mapper: WeatherMapper
): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherUsecase , mapper) as T
    }
}