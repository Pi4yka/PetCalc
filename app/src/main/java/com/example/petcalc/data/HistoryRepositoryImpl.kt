package com.example.petcalc.data

import com.example.petcalc.data.db.HistoryDao
import com.example.petcalc.data.entity.History
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(private val historyDao: HistoryDao) {

    suspend fun insertHistoryItem(history: History) = historyDao.insertHistoryItem(history)

    suspend fun deleteHistoryItem(history: History) = historyDao.deleteHistoryItem(history)

    fun getAllHistoryItem() = historyDao.getAllHistoryItem()
}