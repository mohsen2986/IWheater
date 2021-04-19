package com.iweather.remote.service

import com.iweather.remote.model.CityWeatherDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{

    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String = "Birjand",
        @Query("appid") apiKey: String = "e66eeac39bcb454d2218912c1e5b5bf2"
    ): CityWeatherDto

}