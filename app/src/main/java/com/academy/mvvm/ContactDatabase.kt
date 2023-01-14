package com.academy.mvvm

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//Database Class
@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO

    companion object{
        // 1-> CURRENT DB VERSION, 2-> UPDATED DB VERSION
        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }
        @Volatile // to notify all threads for any update in INSTANCE variable
        private var INSTANCE : ContactDatabase?=null
        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE==null){
                // Blocking for multiple threads
                synchronized(this){
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contactDB")
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}