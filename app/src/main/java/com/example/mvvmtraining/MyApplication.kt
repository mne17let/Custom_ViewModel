package com.example.mvvmtraining

import android.app.Application
import com.example.mvvmtraining.Data.MySharedPreference
import com.example.mvvmtraining.Model.Model
import com.example.mvvmtraining.ViewModel.ViewModel

class MyApplication: Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = ViewModel(Model(MySharedPreference(this)))
    }
}