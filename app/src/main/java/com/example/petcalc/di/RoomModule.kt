package com.example.petcalc.di

import android.content.Context
import androidx.room.Room
import com.example.petcalc.data.db.HistoryDao
import com.example.petcalc.data.db.HistoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): HistoryDatabase =
        Room.databaseBuilder(
            context,
            HistoryDatabase::class.java,
            "history_db.db"
        ).build()

    @Singleton
    @Provides
    fun provideDao(historyDatabase: HistoryDatabase): HistoryDao =
        historyDatabase.historyDao()

}