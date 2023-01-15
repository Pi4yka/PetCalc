package com.example.petcalc.screen.third

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.petcalc.R
import com.example.petcalc.data.entity.Breed
import com.example.petcalc.databinding.FragmentThirdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        val breeds = emptyList<Breed>()
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, Breed.values())
        bindingThirdFragment.dropDownBreed.setAdapter(arrayAdapter)

        val dogImgResultObserver = Observer<String> { imageDogResult ->
            Glide.with(this)
                .load(imageDogResult)
                .fitCenter()
                .into(bindingThirdFragment.imageFromApi)
        }

        viewModel.imageDogResult.observe(viewLifecycleOwner, dogImgResultObserver)

        bindingThirdFragment.buttonLoad.setOnClickListener { loadImage()
        for (breed in Breed.values()) Log.d("TTT","[${breed.ordinal}] -> ${ breed.name }")
        }

        bindingThirdFragment.buttonTest.setOnClickListener { loadBreedImage("pembroke") }

        bindingThirdFragment.dropDownBreed.setOnClickListener {
            val breedDog = this.toString()
            Log.d("TTT","$breedDog")
        }

    }

    private fun loadImage(){
        viewModel.fetchRandImage()
    }

    private fun loadBreedImage(breed: String) {
        viewModel.fetchRandImageBreed(breed)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.imageDogResult.removeObservers(this)
        this._binding = null
    }
}