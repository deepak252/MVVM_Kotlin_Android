package com.academy.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.academy.mvvm.models.Quote
import com.academy.mvvm.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Interacts with QuoteRepository
class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    //View will call this method
    fun getQuotes() : LiveData<List<Quote>>{
        return quoteRepository.getQuotes()
    }

    fun insertQuote( quote: Quote){
        viewModelScope.launch(Dispatchers.IO){
            quoteRepository.insertQuote(quote)
        }
    }
}