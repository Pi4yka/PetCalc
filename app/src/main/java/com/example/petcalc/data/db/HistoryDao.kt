package com.example.petcalc.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.petcalc.data.entity.History

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history_table")
    fun getAllHistoryItem(): LiveData<List<History>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoryItem(history: History): Long

    @Delete
    suspend fun deleteHistoryItem(history: History)
}