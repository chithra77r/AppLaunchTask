package com.applaunch.weatherapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val baseUrl ="https://api.openweathermap.org/"

    fun getApiInstance():Retrofit{
      return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
}