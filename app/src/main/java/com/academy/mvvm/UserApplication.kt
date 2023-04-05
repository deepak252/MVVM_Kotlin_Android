package com.academy.mvvm

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

//All apps that use Hilt must contain an Application class that is annotated with @HiltAndroidApp.
@HiltAndroidApp
class UserApplication : Application() {
    //Field Injection
    @Inject  // Initializes the userRepository (handled by Hilt)
    lateinit var userRepository: UserRepository
    override fun onCreate() {
        super.onCreate()
        userRepository.saveUser("deepak@gmail.com","1234")
        Log.d("MyTag", "UserApplication : $userRepository")
    }
}