package com.iweather.remote.model

import com.google.gson.annotations.SerializedName

data class CityWeatherDto(
    @SerializedName("main")
    val main: MainDto
)

data class MainDto(
    @SerializedName("temp")
    val temp: Double
)