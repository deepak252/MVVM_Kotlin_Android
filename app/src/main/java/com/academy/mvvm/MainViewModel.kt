package com.academy.mvvm

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var count =0;

    fun increment(){
        count++;
    }
    fun decrement(){
        count--;
    }
}