package com.applaunch.weatherapp.api

import com.applaunch.weatherapp.data.model.WeatherDetails
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import retrofit2.http.GET

object WeatherService {

    suspend fun getWeatherApi() = with(Dispatchers.IO) {
        RetrofitService.getApiInstance().create(WeatherApi::class.java).getWeatherDetails().body()
    }


    interface WeatherApi {
        @GET("data/2.5/onecall?lat=12.9082847623315&lon=77.65197822993314&units=imperial&appid=b143bb707b2ee117e62649b358207d3e")
        suspend fun getWeatherDetails(): Response<WeatherDetails>
    }
}
