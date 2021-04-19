package com.iweather.presentation.state

data class MainViewState(val data: List<String> = emptyList(), val error: Exception? = null)
