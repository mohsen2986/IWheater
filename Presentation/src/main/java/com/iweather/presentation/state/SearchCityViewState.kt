package com.iweather.presentation.state

import com.akoufatzis.coolweather.core.Event
import com.iweather.presentation.model.CityView

data class SearchCityViewState(
    val progress: Event<Boolean> = Event(false),
    val error: Exception? = null,
    val data: List<CityView> = emptyList()
)