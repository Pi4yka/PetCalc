package com.example.petcalc.screen.third

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentThirdBinding
import kotlinx.coroutines.cancel

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private var _binding: FragmentThirdBinding? = null
    private val bindingThirdFragment get() = _binding!!
    private val viewModel: ThirdFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return bindingThirdFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dogImgResultObserver = Observer<String> { imageDogResult ->
            Glide.with(this)
                .load(imageDogResult)
                .fitCenter()
                .into(bindingThirdFragment.imageFromApi)
        }

        viewModel.imageDogResult.observe(viewLifecycleOwner, dogImgResultObserver)
        bindingThirdFragment.buttonLoad.setOnClickListener { loadImage() }
    }

     fun loadImage(){
         viewModel.getRandImage()
    }

    override fun onDestroyView() {

        super.onDestroyView()

    }
}