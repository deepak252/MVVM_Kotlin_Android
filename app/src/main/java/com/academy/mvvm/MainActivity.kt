package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//Hilt can provide dependencies to other Android classes that have the @AndroidEntryPoint annotation
// Supported Classes - (Application, Activity, Fragment, ViewModel, View, Service, BroadcastReceiver)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //Field Injection
    @Inject // Initializes the userRepository (handled by Hilt)
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userRepository.saveUser("deepak2@gmail.com","1235")
        Log.d("MyTag", "MainActivity : $userRepository")
    }
}