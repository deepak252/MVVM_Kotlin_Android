package com.academy.mvvm

import android.util.Log
import javax.inject.Inject

interface UserRepository{
    fun saveUser(email : String, password: String)
}
//** @Inject : to get the UserRepository object by calling its constructor
//Constructor Injection
class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(email : String, password : String){
        Log.d("MyTag", "User saved in SQL : $email")
    }
}

class FirebaseRepository : UserRepository {
    override fun saveUser(email : String, password : String){
        Log.d("MyTag", "User saved in Firebase : $email")
    }
}