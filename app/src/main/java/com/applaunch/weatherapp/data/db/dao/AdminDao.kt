package com.applaunch.weatherapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.applaunch.weatherapp.data.model.Admin
import com.applaunch.weatherapp.data.model.User

@Dao
interface AdminDao {

    @Query("SELECT * FROM admin")
    suspend fun getAllUsers(): List<Admin>

    @Insert
    suspend fun insertAdmin(admin: Admin): Long

    @Query("SELECT adminId FROM ADMIN where userName =:userName")
    fun getAdminIdByUserName(userName: String): Long?

}