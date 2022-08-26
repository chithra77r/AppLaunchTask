package com.applaunch.weatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var firstName:String = "",
    var lastName:String = "",
    var mailId:String = "",
    val adminId: Long) {
    @PrimaryKey(autoGenerate = true) var userId: Long=0

}