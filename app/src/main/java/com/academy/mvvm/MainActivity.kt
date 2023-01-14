package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var database : ContactDatabase
    lateinit var tvContact : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvContact = findViewById(R.id.tvContact)

        database= ContactDatabase.getDatabase(this);
//        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java,"contactDB").build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Deepak","9999999999", Date()))
        }

    }

    fun getData(v: View){
        database.contactDao().getContact().observe(this){
            tvContact.text=it.toString()
        }
    }
    fun deleteData(v: View){

        GlobalScope.launch {
//            database.contactDao().deleteContact(Contact(1,"Deepak","9999999999"))
//            val contacts = database.contactDao().getContact().value
//            if(contacts!=null){
//                for(contact in contacts){
//                    database.contactDao().deleteContact(contact)
//                }
//            }
        }
    }

}