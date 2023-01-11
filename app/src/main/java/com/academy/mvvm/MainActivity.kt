package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private val tvFacts : TextView
        get()=findViewById(R.id.tvFacts)

    private val btnUpdate : Button
        get()=findViewById(R.id.btnUpdate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.factsLiveData.observe(this) {
            tvFacts.text=it
        }
        btnUpdate.setOnClickListener{
//            mainViewModel.factsLiveData.value="Hello"
            mainViewModel.updateLiveData()
        }
    }
}