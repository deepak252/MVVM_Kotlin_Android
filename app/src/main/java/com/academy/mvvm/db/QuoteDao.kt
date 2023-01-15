package com.academy.mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.academy.mvvm.models.Quote

@Dao
interface QuoteDao {
    @Insert
    suspend fun insertQuote(quote : Quote)

    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<Quote>>
}