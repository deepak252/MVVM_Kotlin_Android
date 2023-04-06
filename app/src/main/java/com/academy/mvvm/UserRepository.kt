package com.academy.mvvm

import android.util.Log
import javax.inject.Inject
//** @Inject : to get the UserRepository object by calling its constructor
//Constructor Injection
class UserRepository @Inject constructor(val loggerService: LoggerService) {
    fun saveUser(email : String, password : String){
//        Log.d("MyTag", "User saved in DB : $email")
        loggerService.log("User saved in DB : $email")
    }
}