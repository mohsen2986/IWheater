package com.iweather.presentation.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.akoufatzis.coolweather.core.Event
import com.iweather.domain.base.*
import com.iweather.domain.models.Weather
import com.iweather.domain.usecases.SearchCityUseCase
import com.iweather.domain.usecases.WeatherUsecase
import com.iweather.presentation.mapper.WeatherMapper
import com.iweather.presentation.model.WeatherData
import com.iweather.presentation.state.WeatherViewState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel constructor(
    val weatherUseCase: WeatherUsecase ,
    val searchCityUseCase: SearchCityUseCase ,
    private val mapper: WeatherMapper
) : ViewModel() {

    private val _viewState = MutableLiveData<WeatherViewState>()
    val viewState: LiveData<WeatherViewState>
        get() = _viewState

    private val _searchTextState: MutableStateFlow<String> = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchTextState

    fun searchCity(cityName: String){
        _searchTextState.update { cityName }
    }
    init {
        viewModelScope.launch {
            _searchTextState.filter { it.isNotEmpty() }.debounce(500).collectLatest {
                searchCityUseCase(it).collectLatest { value ->
                    when(value){
                        is Failure -> {
                            Log.d("mohsen_" , "Failure ${value}")
                        }
                        is Success -> {
                            Log.d("mohsen_" , "success ${value.data}")
                        }
                        Loading -> {}
                    }
                }
            }
        }
    }

    fun showWeather(placeName: String) = viewModelScope.launch {
        showLoading()

        launch {
            weatherUseCase(placeName).collectLatest {  value: DataHolder<Weather> ->
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

                    else -> {}
                }
            }
        }

        launch {

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
