package com.iweather.presentation.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.akoufatzis.coolweather.core.Event
import com.iweather.domain.base.*
import com.iweather.domain.models.Weather
import com.iweather.domain.usecases.WeatherUsecase
import com.iweather.presentation.mapper.WeatherMapper
import com.iweather.presentation.model.WeatherData
import com.iweather.presentation.state.WeatherViewState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WeatherViewModel constructor(
    val weatherUseCase: WeatherUsecase ,
    private val mapper: WeatherMapper
) : ViewModel() {

    private val _viewState = MutableLiveData<WeatherViewState>()
    val viewState: LiveData<WeatherViewState>
        get() = _viewState

    @OptIn(InternalCoroutinesApi::class)
    fun showWeather(placeName: String) = viewModelScope.launch {
        showLoading()

        weatherUseCase(placeName).collect { value: DataHolder<Weather> ->
            when(value) {
                is Success -> {
                    val weatherData = mapper.mapToView(value.data)
                    Log.e("Log__" , "Success ${value.data}")
                    emitUiState(showSuccess = weatherData)
                }
                is Failure -> {
                    Log.e("Log__" , "Fail ${value}")
                    emitUiState(null!!)
                }
            }
        }
        when( weatherUseCase(placeName).asLiveData().value){
            is Success ->{

            }
        }
    }


    private fun showLoading() {
        emitUiState(showProgress = Event(true))
    }

    private fun emitUiState(
        showProgress: Event<Boolean> = Event(false),
        showError: Exception? = null,
        showSuccess: WeatherData? = null
    ) {
        val viewState = WeatherViewState(
            showProgress,
            showError,
            showSuccess
        )
        _viewState.value = viewState
    }
}
