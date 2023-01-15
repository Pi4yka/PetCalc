package com.example.petcalc.screen.third

import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petcalc.R
import com.example.petcalc.data.entity.Breed
import com.example.petcalc.data.repository.DogRepository
import com.example.petcalc.util.RequestResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThirdFragmentViewModel @Inject constructor(
    private val dogRepository: DogRepository
) : ViewModel() {

    val imageDogResult: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        Log.d("TTT", "ThirdFragment ViewModel is init")
    }

    fun fetchRandImage() {
        Log.d("TTT", "ThirdFragment ViewModel is init")
        viewModelScope.launch() {
            Log.d("TTT", "ThirdFragment ViewModel launch")
            when (val response = dogRepository.getDogs()) {
                is RequestResult.Success -> {
                    imageDogResult.postValue(response.data.imageUrl)
                }
                is RequestResult.Error -> {
                    Log.d("TTT", response.message)
                }
            }

        }
    }

    fun fetchRandImageBreed(breed: String) {
        Log.d("TTT", "ThirdFragment ViewModel is init")
        viewModelScope.launch() {
            Log.d("TTT", "ThirdFragment ViewModel launch")
            when (val response = dogRepository.getBreedDogs(breed)) {
                is RequestResult.Success -> {
                    imageDogResult.postValue(response.data.imageUrl)
                }
                is RequestResult.Error -> {
                    Log.d("TTT", response.message)
                }
            }

        }
    }


    override fun onCleared() {
        Log.d("TTT", "ThirdFragment ViewModel is cleared")
        super.onCleared()
    }
}