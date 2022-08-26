package com.applaunch.weatherapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.applaunch.weatherapp.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user where adminId == :adminId")
    suspend fun getAllUsersByAdminId(adminId: Long): List<User>

    @Insert
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}