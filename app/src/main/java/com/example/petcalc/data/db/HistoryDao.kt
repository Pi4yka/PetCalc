package com.example.petcalc.data.db

import androidx.room.*
import com.example.petcalc.data.entity.HistoryEntity

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(historyEntity: HistoryEntity)

    @Delete
    fun deleteHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM history_table")
    fun getAllHistory(): MutableList<HistoryEntity>
}