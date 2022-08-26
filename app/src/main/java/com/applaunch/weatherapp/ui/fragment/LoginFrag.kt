package com.applaunch.weatherapp.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.SharePreferenceManager
import com.applaunch.weatherapp.databinding.FragLoginBinding
import com.applaunch.weatherapp.ui.MainActivity
import com.applaunch.weatherapp.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFrag : Fragment() {


    lateinit var binding: FragLoginBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_login, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        initView()
        setListener()
        return binding.root
    }

    private fun initView() {
        binding.admin = viewModel.admin
    }

    private fun setListener() {

        binding.apply {
            binding.etUserName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    tilUserName.error = null
                }

            })
            binding.etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    tilPassword.error = null
                }

            })


            btLogin.setOnClickListener {

                if (binding.admin!!.userName.isBlank()) {
                    tilUserName.error = getString(R.string.field_error)
                    return@setOnClickListener
                }
                if (binding.admin!!.password.isBlank()) {
                    tilPassword.error = getString(R.string.field_error)
                    return@setOnClickListener
                }
                lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.getAdminIdByUserName()?.let {
                        SharePreferenceManager.putAdminId(it)
                    } ?: kotlin.run {
                        val adminID  = viewModel.insertAdmin()
                        SharePreferenceManager.putAdminId(adminID)
                    }
                    (activity as MainActivity).callUserListFrag()

                }

            }
        }


    }


}