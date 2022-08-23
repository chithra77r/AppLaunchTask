package com.applaunch.weatherapp.model.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.applaunch.weatherapp.model.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>


    @Insert
    fun insertUser(user: User)
}