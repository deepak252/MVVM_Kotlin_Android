package com.academy.mvvm

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
/**
 * Context is required to read quotes.json from assets folder
 */
class MainViewModel(private val context: Context): ViewModel(){
    private var quotes : Array<Quote> = emptyArray()
    private var index =0
    val hasQuotes : Boolean
    get() = quotes.isNotEmpty()

    init {
        quotes = loadQuotesFromAssets()
    }

    fun getQuote() : Quote{
        return quotes[index]
    }

    fun nextQuote() : Quote{
        return quotes[(++index)%quotes.size]
    }

    fun prevQuote() : Quote{
        return quotes[(--index)%quotes.size]
    }

    private fun loadQuotesFromAssets() : Array<Quote>{
        val inputStream = context.assets.open("quotes.json") //open file from assets
        val size  :Int =  inputStream.available() // file size
        val buffer = ByteArray(size) //Define buffer (byte array) of given size
        inputStream.read(buffer) // store input stream in buffer
        inputStream.close() // close inputStream
        // Convert byte array (buffer) into sting format
        val json = String(buffer,Charsets.UTF_8) // as JSON is encoded in UTF_8
        val gson = Gson()
        return gson.fromJson(json,Array<Quote>::class.java)
    }

}