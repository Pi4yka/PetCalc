package com.example.petcalc.screen.first

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class FirstFragmentViewModel(): ViewModel() {

    init{
        Log.d("TEST", "ViewModel is init")
    }

    fun getSize(neckSize: Int,
                bodySize: Int,
                height: Int): String{
//        viewModelScope.launch {
//            fun getSizeValue(
//            ): String {
                return when {
                    bodySize in 28..36 || neckSize in 18..22 && height >= 20 -> "XS"
                    bodySize in 36..40 || neckSize in 22..26 && height >= 26 -> "S"
                    bodySize in 40..46 || neckSize in 26..30 && height >= 30 -> "M"
                    bodySize in 46..50 || neckSize in 30..34 && height >= 36 -> "L"
                    bodySize >= 50 || neckSize >= 34 && height >= 40 -> "XL"
                    else -> "Не могу вычислить"
                }
          //  }
//        }
    }


    override fun onCleared() {
        Log.d("TEST", "ViewModel is cleared")
        super.onCleared()
    }
}