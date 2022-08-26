package com.applaunch.weatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Admin(var userName:String = "",
    var password:String = "") {
    @PrimaryKey(autoGenerate = true) var adminId: Long=0

}