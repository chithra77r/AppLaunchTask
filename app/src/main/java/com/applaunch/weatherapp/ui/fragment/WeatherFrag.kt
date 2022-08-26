package com.applaunch.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.databinding.FragWeatherBinding
import com.applaunch.weatherapp.ui.MainActivity
import com.applaunch.weatherapp.ui.viewmodel.WeatherViewModel


class WeatherFrag : Fragment() {
    lateinit var binding: FragWeatherBinding
    lateinit var viewModel: WeatherViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_weather, container, false)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        intObserver()
        setListeners()
        viewModel.getAllWeatherDetails()
        return binding.root
    }

    private fun intObserver() {
        viewModel.weatherLiveData.observe(requireActivity()) {
            binding.weatherDetail = it
        }
    }

    private fun setListeners() {

        binding.btBack.setOnClickListener {
            (activity as MainActivity).callPopBackStack()
        }

        binding.btLogout.setOnClickListener {
            requireActivity().finish()
        }
    }

}