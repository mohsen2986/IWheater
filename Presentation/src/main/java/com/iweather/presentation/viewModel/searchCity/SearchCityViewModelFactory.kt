package com.iweather.presentation.viewModel.searchCity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iweather.domain.usecases.AddCityToListUseCase
import com.iweather.domain.usecases.SearchCityUseCase
import com.iweather.presentation.mapper.CityMapper

class SearchCityViewModelFactory(
    private val searchCityUseCase: SearchCityUseCase,
    private val addCityToListUseCase: AddCityToListUseCase ,
    private val mapper: CityMapper
    ): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchCityViewModel(searchCityUseCase , addCityToListUseCase ,mapper) as T
    }
}