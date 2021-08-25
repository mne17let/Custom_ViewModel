package com.example.mvvmtraining.Data

import android.content.Context

class MySharedPreference(context: Context): DataSource {

    private  val currentPreferences = context.getSharedPreferences("CountInt", Context.MODE_PRIVATE)

    override fun saveInt(key: String, value: Int) {
        currentPreferences.edit().putInt(key, value).apply()
    }

    override fun getInt(key: String): Int {
        return currentPreferences.getInt(key, 0)
    }
}