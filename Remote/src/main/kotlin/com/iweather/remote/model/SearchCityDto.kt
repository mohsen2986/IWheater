package com.iweather.remote.model

import com.google.gson.annotations.SerializedName

class SearchCityDtoList: ArrayList<SearchCityDto>()

data class SearchCityDto(
        @SerializedName("name")
        val name: String = "",
        @SerializedName("state")
        val state: String = "",
        @SerializedName("country")
        val country: String = "",
)