package com.example.petcalc.presentation.screen.first

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petcalc.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorFragmentViewModel @Inject constructor() : ViewModel() {
    val sizeResult: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun calculateSize(
        neckSize: Int,
        bodySize: Int,
        bodyHeight: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            @StringRes
            val resId: Int = when {
                bodySize in 28..36 || neckSize in 18..22 && bodyHeight >= 20 -> R.string.size_XS
                bodySize in 36..40 || neckSize in 22..26 && bodyHeight >= 26 -> R.string.size_S
                bodySize in 40..46 || neckSize in 26..30 && bodyHeight >= 30 -> R.string.size_M
                bodySize in 46..50 || neckSize in 30..34 && bodyHeight >= 36 -> R.string.size_L
                bodySize in 50..70 || neckSize in 34..45 && bodyHeight in 40..80 -> R.string.size_XL
                else -> R.string.error
            }
            sizeResult.postValue(resId)
        }
    }

}