package com.applaunch.weatherapp.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.applaunch.weatherapp.MyApp
import com.applaunch.weatherapp.data.db.dao.UserDao
import com.applaunch.weatherapp.data.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase :RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object{
         var db: AppDatabase? = null

        fun getDbInstance(): AppDatabase? {
            if (db == null){
                db= Room.databaseBuilder(MyApp.context,AppDatabase::class.java,"UserDb").build()
            }
            return db
        }
    }

}