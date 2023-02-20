package com.example.petcalc.data.db

import androidx.room.*
import com.example.petcalc.data.entity.HistoryEntity
import com.example.petcalc.presentation.screen.history.list.HistoryItem

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(historyEntity: HistoryEntity)

    @Query("DELETE FROM history_table WHERE id = :id")
    fun deleteHistory(id: Int): Int

    @Query("SELECT * FROM history_table")
    fun getAllHistory(): MutableList<HistoryEntity>
}