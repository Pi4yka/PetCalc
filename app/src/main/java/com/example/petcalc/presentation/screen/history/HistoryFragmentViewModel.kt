package com.example.petcalc.presentation.screen.history

import androidx.lifecycle.*
import com.example.petcalc.data.entity.HistoryEntity
import com.example.petcalc.repository.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryFragmentViewModel @Inject constructor(
    private val historyRepostory: HistoryRepository
) : ViewModel() {

    val historyItems: MutableLiveData<List<HistoryEntity>> by lazy {
        MutableLiveData<List<HistoryEntity>>()
    }

    init {
        //пойти в репозиторий взять лист, замапить, запостить в лайвдату
    }

    fun insertHistory(history: HistoryEntity) = viewModelScope.launch {
        historyRepostory.saveHistory(history)
    }

    val getAllHistory = historyItems.postValue(historyRepostory.getAllHistory())
}