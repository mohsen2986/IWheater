package com.iweather.presentation

import com.iweather.presentation.mapper.CityMapper
import com.iweather.presentation.mapper.WeatherMapper
import com.iweather.presentation.viewModel.searchCity.SearchCityViewModelFactory
import com.iweather.presentation.viewModel.weather.WeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val presentationModule = Kodein.Module(name = "PresentationModule"){

    bind() from singleton { WeatherMapper() }
    bind() from singleton { CityMapper() }

    bind() from provider { WeatherViewModelFactory(instance() , instance()) }
    bind() from provider { SearchCityViewModelFactory(instance(), instance() , instance()) }

}