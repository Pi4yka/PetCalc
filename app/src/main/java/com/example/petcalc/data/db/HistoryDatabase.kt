package com.example.petcalc.data.db

import androidx.room.*
import com.example.petcalc.data.entity.History


@Database(
    entities = [History::class],
    version = 1
)
abstract class HistoryDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}