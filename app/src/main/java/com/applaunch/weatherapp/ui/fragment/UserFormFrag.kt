package com.applaunch.weatherapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.databinding.FragLoginBinding
import com.applaunch.weatherapp.databinding.FragUserFormBinding

class UserFormFrag:Fragment(){

    lateinit var binding: FragUserFormBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= DataBindingUtil.inflate(inflater,R.layout.frag_user_form,container,false)
        setListioner()
        return binding.root;
    }

    private fun setListioner() {

    }

}