package com.applaunch.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaunch.weatherapp.data.model.User
import com.applaunch.weatherapp.data.model.WeatherDetails
import com.applaunch.weatherapp.data.repo.UserRepo
import com.applaunch.weatherapp.data.repo.WeatherRepo
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {


    var weatherLiveData =  MutableLiveData<WeatherDetails>()

    fun getAllWeatherDetails(){
        viewModelScope.launch {
            weatherLiveData.postValue(WeatherRepo.getWeatherDetails())
        }
    }

}