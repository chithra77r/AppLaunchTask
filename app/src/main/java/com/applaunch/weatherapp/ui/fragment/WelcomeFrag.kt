package com.applaunch.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.databinding.FragWelcomeBinding
import com.applaunch.weatherapp.ui.MainActivity

class WelcomeFrag : Fragment() {


    lateinit var binding: FragWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_welcome, container, false)
        setListeners()

        return binding.root
    }

    fun setListeners() {

        binding.btLogin.setOnClickListener {
            (activity as MainActivity).callLoginFrag()
        }

    }


}
