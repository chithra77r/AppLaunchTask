package com.applaunch.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.databinding.ActivityMainBinding
import com.applaunch.weatherapp.ui.fragment.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var manager: FragmentManager;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        manager = supportFragmentManager;
        callWelcomeFrag()
    }

    private fun callWelcomeFrag() {
        val welcoemFrag = WelcomeFrag();
        manager.beginTransaction().add(R.id.container, welcoemFrag).commit()
    }

    fun callLoginFrag() {
        val loginFrag = LoginFrag()
        manager.beginTransaction().add(R.id.container, loginFrag).commit()
    }

    fun callUserListFrag() {
        val userListFrag = UserListFrag()
        manager.beginTransaction().apply {
            add(R.id.container, userListFrag)
            commit()
        }
    }

    fun callUserFormFrag(isBackStackNeeded: Boolean = false) {
        val userFormFrag = UserFormFrag()
        manager.beginTransaction().apply {
            replace(R.id.container, userFormFrag)
            if(isBackStackNeeded) {
                addToBackStack(null)
            }
            commit()
        }
    }

    fun callPopBackStack() {
        manager.popBackStack()
    }

    fun callWeatherFrag() {
        val weatherFrag = WeatherFrag()
        manager.beginTransaction().apply {
            add(R.id.container, weatherFrag)
            addToBackStack(null)
            commit()
        }
    }
}