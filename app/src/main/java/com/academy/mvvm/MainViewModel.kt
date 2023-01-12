package com.academy.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val nameLiveData = MutableLiveData("Deepak")
    val quoteLiveData = MutableLiveData<Quote>(Quote("Hello","Auth"))

    fun updateQuote(){
        quoteLiveData.value=Quote("Quote Updated", "Auth updated")

    }
}