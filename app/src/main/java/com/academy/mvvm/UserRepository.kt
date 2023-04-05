package com.academy.mvvm

import android.util.Log
import javax.inject.Inject
//** @Inject : to get the UserRepository object by calling its constructor
class UserRepository @Inject constructor() {
    fun saveUser(email : String, password : String){
        Log.d("MyTag", "User saved in DB : $email")
    }
}