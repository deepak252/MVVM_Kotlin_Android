package com.academy.mvvm.repository

import androidx.lifecycle.LiveData
import com.academy.mvvm.db.QuoteDao
import com.academy.mvvm.models.Quote

class QuoteRepository(private val quoteDao: QuoteDao) {
    fun getQuotes() : LiveData<List<Quote>>{
        //Logic eg. fetch data from API
        return quoteDao.getQuotes()
    }
    suspend fun insertQuote(quote : Quote){
        quoteDao.insertQuote(quote)
    }
}