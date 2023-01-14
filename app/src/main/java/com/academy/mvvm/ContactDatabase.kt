package com.academy.mvvm

import android.content.Context
import androidx.room.*

//Database Class
@Database(entities = [Contact::class], version = 1)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO

    companion object{
        @Volatile // to notify all threads for any update in INSTANCE variable
        private var INSTANCE : ContactDatabase?=null
        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE==null){
                // Blocking for multiple threads
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contactDB").build()
                }
            }
            return INSTANCE!!
        }

    }
}