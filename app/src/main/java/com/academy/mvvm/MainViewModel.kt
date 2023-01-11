package com.academy.mvvm

import androidx.lifecycle.ViewModel

class MainViewModel(private val initialVal : Int=0) : ViewModel() {
    var count =initialVal;

    fun increment(){
        count++;
    }
    fun decrement(){
        count--;
    }
}