package com.example.petcalc.data.db

import androidx.lifecycle.LiveData
import com.example.petcalc.data.entity.History
import javax.inject.Inject

class DBRepository @Inject constructor(val historyDatabase: HistoryDatabase) {

    suspend fun insertHistoryItem(history: History): Long {
        return historyDatabase.historyDao().insertHistoryItem(history)
    }

    suspend fun delete(history: History) {
        historyDatabase.historyDao().deleteHistoryItem(history)
    }

    fun getAllHistoryItem(): LiveData<List<History>> {
        return historyDatabase.historyDao().getAllHistoryItems()
    }
}