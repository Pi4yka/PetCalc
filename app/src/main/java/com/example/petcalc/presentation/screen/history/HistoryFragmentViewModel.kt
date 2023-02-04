package com.example.petcalc.presentation.screen.history

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.petcalc.data.db.DBRepository
import com.example.petcalc.data.entity.History
import javax.inject.Inject

class HistoryFragmentViewModel @Inject constructor( private val repository: DBRepository): ViewModel() {

    fun getAllHistoryItem() = repository.getAllHistoryItem()
    init {
        //пойти в репозиторий взять лист, замапить, запостить в лайвдату

    }
}