package com.academy.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var tvQuote  : TextView
    private lateinit var tvAuthor  : TextView
    private lateinit var btnShare : FloatingActionButton
    private lateinit var btnNext : Button
    private lateinit var btnPrevious : Button
    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()


        // pass applicationContext in MainViewModelFactory() as Activity 'this' may be destroyed on screen rotate
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(applicationContext))[MainViewModel::class.java]

        //set initial quote
        if(mainViewModel.hasQuotes){
            setQuote(mainViewModel.getQuote())
        }

    }

    private fun initViews(){
        tvQuote = findViewById(R.id.tvQuote)
        tvAuthor = findViewById(R.id.tvAuthor)
        btnShare = findViewById(R.id.btnShare)
        btnNext = findViewById(R.id.btnNext)
        btnPrevious = findViewById(R.id.btnPrevious)

        btnNext.setOnClickListener{
            nextQuote()
        }
        btnPrevious.setOnClickListener{
            prevQuote()
        }

        btnShare.setOnClickListener{
            shareQuote()
        }
    }

    private fun setQuote(quote: Quote){
        tvQuote.text = quote.text
        tvAuthor.text = quote.author
    }
    private fun nextQuote(){
        if(mainViewModel.hasQuotes){
            setQuote(mainViewModel.nextQuote())
        }
    }
    private fun prevQuote(){
        if(mainViewModel.hasQuotes){
            setQuote(mainViewModel.prevQuote())
        }
    }
    private fun shareQuote(){
        try {
            //Implicit Intent
            val intent = Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote()!!.text)
            startActivity(intent)
        }catch (e : Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT)
                .show()
        }
    }
}