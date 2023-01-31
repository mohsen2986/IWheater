package com.iweather.remote

import com.iweather.data.repository.city.CityRemote
import com.iweather.data.repository.weather.WeatherRemote
import com.iweather.data.source.city.CityRemoteDataSource
import com.iweather.data.source.weather.WeatherRemoteDataSource
import com.iweather.remote.mapper.SearchCityResponseModelMapper
import com.iweather.remote.mapper.WeatherResponseModelMapper
import com.iweather.remote.service.ApiInterface
import com.iweather.remote.service.ApiServiceFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val remoteModule = Kodein.Module(name = "RemoteModule"){
    bind() from singleton {  WeatherResponseModelMapper() }
    bind() from singleton { SearchCityResponseModelMapper() }

    bind<ApiInterface>() with singleton {ApiServiceFactory.createService()}

    bind<WeatherRemote>() with singleton { WeatherRemoteRepositoryImpl(instance() , instance() ) }
    bind<CityRemote>() with singleton { CityRemoteRepositoryImpl(instance() , instance() ) }

    bind() from singleton { WeatherRemoteDataSource(instance()) }
    bind() from singleton { CityRemoteDataSource(instance()) }
}