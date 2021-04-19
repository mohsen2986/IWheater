package com.iweather.presentation.model

data class WeatherData(val place: String, val tempData: TemperatureData, val iconRes: Int)

data class TemperatureData(val degrees: Double)