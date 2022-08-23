package com.applaunch.weatherapp.data.model

data class Weather(val current: Current)

data class Current(val temp:Float,val humidity:Int,val windSpeed:Float)