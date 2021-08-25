package com.example.mvvmtraining.Model

import java.sql.Time
import java.util.*

class Model {

    private var timer: Timer? = null
    private lateinit var callback: TextCallbackForModel

    private val timerTask: TimerTask = object : TimerTask(){
        override fun run() {
            count++
            callback.updateText(count.toString())
        }
    }

    private var count = 0

    fun setCallback(callback: TextCallbackForModel){
        this.callback = callback
    }

    fun start(){
        if (timer == null){
            timer = Timer()
            timer?.scheduleAtFixedRate(timerTask, 1000, 1000)
        }
    }
}