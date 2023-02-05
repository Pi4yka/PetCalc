package com.example.petcalc.presentation.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petcalc.data.HistoryRepositoryImpl
import com.example.petcalc.data.entity.History
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryFragmentViewModel @Inject constructor(private val repository: HistoryRepositoryImpl) :
    ViewModel() {

    fun getAllHistoryItem() = repository.getAllHistoryItem()

    fun addHistoryItem(
        nickname: String,
        neckSize: Int,
        bodySize: Int,
        heightSize: Int,
        sizeText: String
    ) = viewModelScope.launch {
        val historyObject = History(
            nickname = nickname,
            neckSize = neckSize,
            bodySize = bodySize,
            heightSize = heightSize,
            sizeText = sizeText
        )
        repository.insertHistoryItem(historyObject)
    }

    init {
        //пойти в репозиторий взять лист, замапить, запостить в лайвдату

    }
}