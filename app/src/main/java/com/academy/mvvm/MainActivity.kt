package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.academy.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        setContentView(R.layout.activity_main)
        binding.quote = Quote("Do or Die","User")
//        binding.tvQuote.text = "Do or Die"
//        binding.tvAuthor.text="Anonymous"
    }
}