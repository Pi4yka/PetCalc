package com.example.petcalc.data.repository

import com.example.petcalc.data.db.HistoryDao
import com.example.petcalc.data.entity.HistoryEntity
import com.example.petcalc.presentation.screen.history.list.HistoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val dao: HistoryDao
) {

     fun saveHistory(history: HistoryEntity) = dao.insertHistory(history)
     fun deleteHistory(history: Int) = dao.deleteHistory(history)
     fun getAllHistory(): List<HistoryEntity> = dao.getAllHistory()

}