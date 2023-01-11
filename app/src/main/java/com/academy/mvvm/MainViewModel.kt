package com.academy.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(private val quotes : List<Quote>): ViewModel(){
    var index =0
    fun getNextQuote() : Quote?{
        if(index<quotes.size-1){
            index++
            return quotes[index]
        }
        return null
    }
    fun getPrevQuote() : Quote?{
        if(index>0){
            index--
            return quotes[index]
        }
        return null
    }

}