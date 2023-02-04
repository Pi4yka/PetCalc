package com.example.petcalc.data.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.petcalc.data.entity.History
import com.example.petcalc.di.PetCalcApplication
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [History::class],
    version = 1
)

abstract class HistoryDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao

}