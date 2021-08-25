package com.example.mvvmtraining

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmtraining.ViewModel.TextObservable
import com.example.mvvmtraining.ViewModel.ViewModel

class MainActivity: AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init(){
        textView = findViewById(R.id.id_textView)
        val textObservable: TextObservable = TextObservable()
        textObservable.observe(object : TextCallbackForObserver{
            override fun updateText(string: String) {
                runOnUiThread(object : Runnable{
                    override fun run() {
                        textView.text = string
                    }

                })
            }
        })

        val myApplication: MyApplication = application as MyApplication
        viewModel = myApplication.viewModel
        viewModel.startViewModel(textObservable)
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}