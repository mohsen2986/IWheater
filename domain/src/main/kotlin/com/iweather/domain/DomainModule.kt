package com.iweather.domain

import com.iweather.domain.usecases.SearchCityUseCase
import com.iweather.domain.usecases.WeatherUsecase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val domainModule = Kodein.Module(name = "DomainModule") {

    bind() from singleton { WeatherUsecase(instance()) }
    bind() from singleton { SearchCityUseCase(instance()) }
}