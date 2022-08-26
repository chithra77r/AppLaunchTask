package com.applaunch.weatherapp.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.applaunch.weatherapp.R
import com.applaunch.weatherapp.data.model.User
import com.applaunch.weatherapp.databinding.FragLoginBinding
import com.applaunch.weatherapp.databinding.FragUserFormBinding
import com.applaunch.weatherapp.ui.MainActivity
import com.applaunch.weatherapp.ui.viewmodel.UserViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class UserFormFrag : Fragment() {

    lateinit var binding: FragUserFormBinding
    lateinit var user: User;
    lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_user_form, container, false)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        initView()
        setListener()
        return binding.root;
    }

    private fun initView() {
        binding.user = userViewModel.user
    }

    private fun setListener() {
        binding.apply {
            resetError(tilFirstName, tieFirstName)
            resetError(tilLastName, tieLastName)
            resetError(tilEmail, tieEmail)

            btSave.setOnClickListener {
                if (tieFirstName.text.toString().isBlank()){
                    tilFirstName.error= getString(R.string.field_error)
                    return@setOnClickListener
                }
                if (tieLastName.text.toString().isBlank()){
                    tilLastName.error=getString(R.string.field_error)
                    return@setOnClickListener
                }
                if (tieEmail.text.toString().isBlank()){
                    tilEmail.error=getString(R.string.field_error)
                    return@setOnClickListener
                }
                userViewModel.insertUser()
                (activity as MainActivity).callPopBackStack()
            }

            btCancel.setOnClickListener {
                (activity as MainActivity).callPopBackStack()
            }

        }

    }

    private fun resetError(til: TextInputLayout, et: TextInputEditText) {
        et.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                til.error= null
            }

        })
    }

}