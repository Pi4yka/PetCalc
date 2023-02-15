package com.example.petcalc.presentation.screen.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petcalc.data.entity.HistoryEntity
import com.example.petcalc.data.repository.HistoryRepository
import com.example.petcalc.presentation.screen.history.list.HistoryItem
import com.example.petcalc.presentation.screen.history.list.toItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryFragmentViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
) : ViewModel() {

    val historyItems: MutableLiveData<List<HistoryItem>> by lazy {
        MutableLiveData<List<HistoryItem>>()
    }

    init {
        fetchHistoryList()
    }

    fun fetchHistoryList() {
        viewModelScope.launch(Dispatchers.IO) {
            historyItems.postValue(historyRepository.getAllHistory().map { it.toItem() })
        }
    }

    fun deleteHistoryItem(historyId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            historyRepository.deleteHistory(historyId)
        }
    }

    fun insertHistory(history: HistoryEntity) {
        viewModelScope.launch {
            historyRepository.saveHistory(history)
        }
    }

}