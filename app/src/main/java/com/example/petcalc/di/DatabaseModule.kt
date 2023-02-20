package com.example.petcalc.di

import android.content.Context
import androidx.room.Room
import com.example.petcalc.data.db.HistoryDatabase
import com.example.petcalc.data.entity.HistoryEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            HistoryDatabase::class.java,
            "history_db.db"
        ).build()

    @Singleton
    @Provides
    fun provideDao(db: HistoryDatabase) = db.historyDao()

}