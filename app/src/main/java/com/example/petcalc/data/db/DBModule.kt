package com.example.petcalc.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    @Singleton
    @Provides
    fun provideHistoryDatabase(@ApplicationContext context: Context): HistoryDatabase =
        Room.databaseBuilder(
            context,
            HistoryDatabase::class.java,
            "history_db.db"
        ).build()
}