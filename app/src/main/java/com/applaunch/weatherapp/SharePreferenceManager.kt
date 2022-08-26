package com.applaunch.weatherapp

import android.content.Context.MODE_PRIVATE
import android.view.Display
import androidx.transition.Visibility

object SharePreferenceManager {
    val sharedPreferences = MyApp.context.getSharedPreferences("Mydata", MODE_PRIVATE);

    const val ADMIN_ID = "ADMIN_ID"

    fun putAdminId(value: Long) = with(sharedPreferences.edit()) {
        putLong(ADMIN_ID, value)
        commit()
    }

    fun getAdminId(): Long = sharedPreferences.getLong(ADMIN_ID, -1)


}