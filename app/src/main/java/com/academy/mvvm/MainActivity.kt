package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var txtCounter : TextView
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCounter = findViewById(R.id.txtCounter)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setText()
    }
    private fun setText(){
        txtCounter.text=mainViewModel.count.toString()
    }
    fun incrementCounter(v:View){
        mainViewModel.increment()
        setText()
    }

    fun decrementCounter(v:View){
        mainViewModel.decrement()
        setText()
    }
}