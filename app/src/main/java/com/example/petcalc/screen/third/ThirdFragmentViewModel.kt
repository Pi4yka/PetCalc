package com.example.petcalc.screen.third

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.petcalc.data.DogCeoInstance
import com.example.petcalc.data.entity.ImageResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ThirdFragmentViewModel @Inject constructor() : ViewModel() {

    val imageDogResult: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        Log.d("TTT", "ThirdFragment ViewModel is init")

    }

    fun getRandImage(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = try {
                DogCeoInstance.api.getDogImageByBreed()
            } catch (e: IOException) {
                Log.e("TTT","IOException, Check your internet connection")
                return@launch
            } catch (e: HttpException){
                Log.e("TTT","HttpException, unexpected response")
                return@launch
            }
            if (response.isSuccessful && response.body() != null){
                Log.e("TTT","${response.body()!!.message}")
            } else {
                Log.e("TTT","Response not successful")
            }
            imageDogResult.postValue(response.body()!!.message)
        }
    }


    override fun onCleared() {
        Log.d("TTT", "ThirdFragment ViewModel is cleared")
        super.onCleared()
    }
}