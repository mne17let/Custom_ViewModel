package com.example.mvvmtraining.ViewModel

import android.view.Display
import com.example.mvvmtraining.Model.Model
import com.example.mvvmtraining.Model.TextCallbackForModel

class ViewModel(private val model: Model) {

    private var textObservable: TextObservable? = null

    val callBackForModel: TextCallbackForModel = object : TextCallbackForModel {
        override fun updateText(string: String) {
            textObservable?.postValue(string)
        }

    }

    fun startViewModel(observable: TextObservable){
        textObservable = observable
        model.setCallback(callBackForModel)
        model.start()
    }

    fun clear(){
        textObservable = null
    }

}