package com.applaunch.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaunch.weatherapp.SharePreferenceManager
import com.applaunch.weatherapp.data.model.User
import com.applaunch.weatherapp.data.repo.UserRepo
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    val user = User(adminId = SharePreferenceManager.getAdminId());

    var userLiveData =  MutableLiveData<MutableList<User>>()

    fun insertUser() {
      viewModelScope.launch {
          UserRepo.insertUser(user)
      }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            UserRepo.deleteUser(user)
        }
    }

    fun getAllUsers(adminId : Long){
        viewModelScope.launch {
            userLiveData.postValue(UserRepo.getAllUsersByAdminId(adminId))
        }
    }

}