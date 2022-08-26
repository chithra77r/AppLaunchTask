package com.applaunch.weatherapp.data.repo

import com.applaunch.weatherapp.api.WeatherService

object WeatherRepo {
    suspend fun getWeatherDetails() = WeatherService.getWeatherApi()
}