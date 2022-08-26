package com.applaunch.weatherapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaunch.weatherapp.data.model.Admin
import com.applaunch.weatherapp.data.model.User
import com.applaunch.weatherapp.data.repo.AdminRepo
import com.applaunch.weatherapp.data.repo.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    val admin = Admin();

    suspend fun insertAdmin() = withContext(Dispatchers.IO) {
        AdminRepo.insertAdmin(admin)
    }

    suspend fun getAdminIdByUserName(): Long? {
        return withContext(Dispatchers.IO) {
            AdminRepo.adminDao.getAdminIdByUserName(admin.userName)
        }
    }

}