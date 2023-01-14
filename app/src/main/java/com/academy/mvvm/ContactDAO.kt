package com.academy.mvvm

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {
    //suspend function used to execute query in background thread (coroutines)
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<Contact>> //By default LiveData executes on bg thread
}