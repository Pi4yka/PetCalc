package com.example.petcalc.data

import com.example.petcalc.data.entity.History

interface HistoryRepository {
    fun addHistory(history: History)
    fun getAll(): List<History>
}