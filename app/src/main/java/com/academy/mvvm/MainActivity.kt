package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.academy.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // binding.mainViewModel must be set here to access in activity_mail.xml file
        binding.mainViewModel = mainViewModel
        // lifecycleOwner must be set here to access liveData ("quoteLiveData") in activity_mail.xml
        binding.lifecycleOwner = this

//        mainViewModel.quoteLiveData.observe(this){
//            binding.quote =it
//        }

//        binding.btnUpdate.setOnClickListener {
//            mainViewModel.updateQuote()
//        }

    }
}