package com.example.petcalc.data.repository

import com.example.petcalc.data.db.HistoryDao
import com.example.petcalc.data.entity.HistoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val dao: HistoryDao
) {

    suspend fun saveHistory(history: HistoryEntity) {
        withContext(Dispatchers.IO) {
            dao.insertHistory(history)
        }
    }

    suspend fun deleteHistory(history: HistoryEntity) = dao.deleteHistory(history)
    suspend fun getAllHistory(): List<HistoryEntity> = dao.getAllHistory()

}