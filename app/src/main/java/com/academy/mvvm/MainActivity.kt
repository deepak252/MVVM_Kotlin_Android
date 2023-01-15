package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.academy.mvvm.databinding.ActivityMainBinding
import com.academy.mvvm.db.QuoteDatabase
import com.academy.mvvm.models.Quote
import com.academy.mvvm.repository.QuoteRepository
import com.academy.mvvm.viewmodels.MainViewModel
import com.academy.mvvm.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val quoteDao = QuoteDatabase.getDatabase(this).quoteDao()
        val quoteRepository = QuoteRepository(quoteDao)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(quoteRepository))[MainViewModel::class.java]

        mainViewModel.getQuotes().observe(this){
            binding.quotes=it.toString()
        }

        binding.btnInsertQuote.setOnClickListener{
            mainViewModel.insertQuote(Quote(0,"Sample Quote", "Anonymous"))

        }
    }
}