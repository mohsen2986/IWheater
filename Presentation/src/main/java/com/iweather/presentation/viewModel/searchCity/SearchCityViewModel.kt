package com.iweather.presentation.viewModel.searchCity

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akoufatzis.coolweather.core.Event
import com.iweather.domain.base.Failure
import com.iweather.domain.base.Loading
import com.iweather.domain.base.Success
import com.iweather.domain.usecases.SearchCityUseCase
import com.iweather.presentation.mapper.CityMapper
import com.iweather.presentation.model.CityView
import com.iweather.presentation.state.SearchCityViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchCityViewModel(
    val searchCityUseCase: SearchCityUseCase,
    private val mapper: CityMapper,
) : ViewModel() {

    private val _searchTextState: MutableStateFlow<String> = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchTextState

    private val _viewState: MutableStateFlow<SearchCityViewState> = MutableStateFlow(
        SearchCityViewState())
    val searchResult: StateFlow<SearchCityViewState> = _viewState

    fun searchCity(cityName: String) {
        _searchTextState.update { cityName }
    }


    init {
        viewModelScope.launch {
            _searchTextState
                .filter { it.isNotEmpty() }
                .debounce(500)
                .collectLatest {
                    searchCityUseCase(it).collectLatest { value ->
                        when (value) {
                            is Failure -> {
                                _viewState.update {
                                    it.copy(
                                        error = it.error
                                    )
                                }
                            }
                            is Success -> {
                                Log.d("mohsen_" , "the response is $it")
                                _viewState.update {
                                    it.copy(
                                        data = value.data.map { mapper.mapToView(it) }
                                    )
                                }
                            }
                            Loading -> {
                                _viewState.update {
                                    it.copy(
                                        progress = Event(true)
                                    )
                                }
                            }
                        }
                    }
                }
        }
    }
}