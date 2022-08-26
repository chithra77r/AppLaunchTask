package com.applaunch.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherDetails(val current: Current)

data class Current(val temp:Float, val humidity:Int, @SerializedName(value = "wind_speed") val windSpeed:Float, val weather:List<Weather>)

data class Weather(val main:String)