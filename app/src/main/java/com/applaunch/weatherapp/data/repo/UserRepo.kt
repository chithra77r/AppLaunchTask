package com.applaunch.weatherapp.data.repo

import androidx.lifecycle.LiveData
import com.applaunch.weatherapp.api.WeatherService
import com.applaunch.weatherapp.data.db.AppDatabase
import com.applaunch.weatherapp.data.db.dao.UserDao
import com.applaunch.weatherapp.data.model.User

object UserRepo {

    var userDao = AppDatabase.getDbInstance()?.userDao()!!

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

   suspend fun getAllUsersByAdminId(adminId: Long): MutableList<User>{
      return userDao.getAllUsersByAdminId(adminId).toMutableList()
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}