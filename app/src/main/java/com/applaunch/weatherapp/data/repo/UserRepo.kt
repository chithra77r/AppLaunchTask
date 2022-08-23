package com.applaunch.weatherapp.model.repo

import com.applaunch.weatherapp.model.db.AppDatabase
import com.applaunch.weatherapp.model.db.dao.UserDao

class UserRepo {

    lateinit var userDao :UserDao
    init {
        userDao= AppDatabase.getDbInstance()?.userDao()!!
    }




}