package com.example.mvvmtraining.Data

interface DataSource {

    fun saveInt(key: String, value: Int)

    fun getInt(key: String) :Int
}