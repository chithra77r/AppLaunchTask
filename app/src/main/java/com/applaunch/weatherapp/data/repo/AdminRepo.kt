package com.applaunch.weatherapp.data.repo

import androidx.lifecycle.LiveData
import com.applaunch.weatherapp.api.WeatherService
import com.applaunch.weatherapp.data.db.AppDatabase
import com.applaunch.weatherapp.data.db.dao.UserDao
import com.applaunch.weatherapp.data.model.Admin
import com.applaunch.weatherapp.data.model.User

object AdminRepo {

    var adminDao = AppDatabase.getDbInstance()?.adminDao()!!

    suspend fun insertAdmin(admin: Admin): Long {
        return adminDao.insertAdmin(admin)
    }

   suspend fun getAdminIdByUserName(userName: String): Long?{
      return adminDao.getAdminIdByUserName(userName)
    }

}