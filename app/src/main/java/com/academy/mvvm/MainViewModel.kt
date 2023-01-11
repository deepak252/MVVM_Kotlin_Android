package com.academy.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel() {
    private val factsMutableLiveData = MutableLiveData<String>("Livedata Example")

    val factsLiveData : LiveData<String> // not mutable (Read only)
    get() = factsMutableLiveData

    fun updateLiveData(){
        factsMutableLiveData.value+="\nLiveData Updated "
    }

}