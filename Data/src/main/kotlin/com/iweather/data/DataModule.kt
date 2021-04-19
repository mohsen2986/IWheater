package com.iweather.data

import com.iweather.data.mapper.WeatherMapper
import com.iweather.data.source.WeatherDataSourceFactory
import com.iweather.domain.repositories.WeatherRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val dataModule = Kodein.Module(name = "DataModule") {
    bind() from singleton { WeatherMapper() }
    bind() from singleton { WeatherDataSourceFactory(instance() , instance()) }
    bind<WeatherRepository>() with provider {  WeatherDataRepository(instance() , instance() , instance()) }
}