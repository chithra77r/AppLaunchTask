package com.applaunch.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.databinding.FragWeatherBinding

class WeatherFrag: Fragment() {
    lateinit var binding: FragWeatherBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= DataBindingUtil.inflate(inflater, R.layout.frag_weather,container,false)
        setListeners()
        return binding.root
    }

    private fun setListeners() {

    }
}