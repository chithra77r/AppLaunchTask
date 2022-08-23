package com.applaunch.weatherapp.model.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val userId: Int,
    val firstName:String,
    val lastName:String,
    val mailId:String) {

}