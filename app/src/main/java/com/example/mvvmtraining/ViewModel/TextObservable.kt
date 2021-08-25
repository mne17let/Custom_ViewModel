package com.example.mvvmtraining.ViewModel

import com.example.mvvmtraining.TextCallbackForObserver

class TextObservable {

    private lateinit var callback: TextCallbackForObserver

    fun observe(textCallback: TextCallbackForObserver){
        this.callback = textCallback
    }

    fun postValue(newText: String){
        callback.updateText(newText)
    }
}