package com.iweather.cache.db

object WeatherConstants{

    const val TABLE_NAME = "weather_tbl"

    const val QUERY_WEATHER = "SELECT * FROM $TABLE_NAME"

    const val QUERY_EXISTS = "SELECT EXISTS(SELECT 1 FROM $TABLE_NAME)"
}