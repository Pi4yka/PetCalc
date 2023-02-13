package com.example.petcalc.repository

import com.example.petcalc.data.db.HistoryDao
import com.example.petcalc.data.entity.HistoryEntity
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val dao: HistoryDao
) {

    suspend fun saveHistory(history: HistoryEntity) = dao.insertHistory(history)
    suspend fun deleteHistory(history: HistoryEntity) = dao.deleteHistory(history)
    fun getAllHistory() = dao.getAllHistory()
}