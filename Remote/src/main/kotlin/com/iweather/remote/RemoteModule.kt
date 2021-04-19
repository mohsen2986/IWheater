package com.iweather.remote

import com.iweather.data.repository.WeatherRemote
import com.iweather.data.source.WeatherRemoteDataSource
import com.iweather.remote.mapper.WeatherResponseModelMapper
import com.iweather.remote.service.ApiInterface
import com.iweather.remote.service.ApiServiceFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val remoteModule = Kodein.Module(name = "RemoteModule"){
    bind() from singleton {  WeatherResponseModelMapper() }

    bind<ApiInterface>() with singleton {ApiServiceFactory.createService()}
    bind<WeatherRemote>() with singleton { WeatherRemoteRepositoryImpl(instance() , instance()) }
    bind() from singleton { WeatherRemoteDataSource(instance()) }
}