package com.example.mvvmtraining.Model

import com.example.mvvmtraining.Data.DataSource
import java.sql.Time
import java.util.*

class Model(private val dataSource: DataSource) {

    private var timer: Timer? = null
    private lateinit var callback: TextCallbackForModel

    private var timerTask: TimerTask? = null

    private var count = -1

    fun setCallback(callback: TextCallbackForModel){
        this.callback = callback
    }

    fun start(){
        if (count < 0){
            count = dataSource.getInt(KEY_FOR_PREF)
        }
        timer = Timer()
        timerTask = object : TimerTask(){
            override fun run() {
                count++
                callback.updateText(count.toString())
            }
        }
        timer?.scheduleAtFixedRate(timerTask, 1000, 1000)
    }

    fun stop(){
        dataSource.saveInt(KEY_FOR_PREF, count)
        timer?.cancel()
        timer = null
        timerTask = null
    }



    companion object{
        const val KEY_FOR_PREF = "keyforpref"
    }
}