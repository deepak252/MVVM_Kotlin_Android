package com.academy.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var tvQuote  : TextView
    private lateinit var tvAuthor  : TextView
    private lateinit var btnShare : FloatingActionButton
    private lateinit var btnNext : Button
    private lateinit var btnPrevious : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){
        tvQuote = findViewById(R.id.tvQuote)
        tvAuthor = findViewById(R.id.tvAuthor)
        btnShare = findViewById(R.id.btnShare)
        btnNext = findViewById(R.id.btnNext)
        btnPrevious = findViewById(R.id.btnPrevious)

        btnShare.setOnClickListener{
            shareQuote()
        }
    }

    private fun shareQuote(){
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,tvQuote.text.toString())
            startActivity(intent)
        }catch (e : Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }
}