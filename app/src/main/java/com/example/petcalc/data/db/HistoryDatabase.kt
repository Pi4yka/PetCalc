package com.example.petcalc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.petcalc.data.entity.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1)
abstract class HistoryDatabase: RoomDatabase() {

    abstract fun historyDao(): HistoryDao

}