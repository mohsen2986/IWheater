package com.iweather.presentation.state

import com.akoufatzis.coolweather.core.Event
import com.iweather.presentation.model.WeatherData

data class WeatherViewState(
    val progress: Event<Boolean>,
    val error: Exception?,
    val data: WeatherData?
)
