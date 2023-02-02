package com.example.petcalc.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.petcalc.data.entity.History
import com.example.petcalc.presentation.screen.history.list.HistoryItem

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoryItem(history: History)

    @Query("SELECT * FROM HISTORY")
    fun getAllHistoryItems():LiveData<List<HistoryItem>>

    @Delete
    suspend fun deleteHistoryItem(history: History)
}