package com.example.petcalc.screen.first

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var bindingFragmentFirst: FragmentFirstBinding
    private val viewModel: FirstFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TEST", "Fragment created")
        bindingFragmentFirst = FragmentFirstBinding.bind(view)

        val sizeResultObserver = Observer<String> { sizeResult ->
            bindingFragmentFirst.sizeValueText.text = sizeResult
        }

        viewModel.sizeResult.observe(viewLifecycleOwner, sizeResultObserver)

        bindingFragmentFirst.calcuclateBtn.setOnClickListener { onCalculateClicked() }
    }

    private fun onCalculateClicked() {
        val neckSize = bindingFragmentFirst.neckEditText.text.toString()
        val bodySize = bindingFragmentFirst.bodyEditText.text.toString()
        val height = bindingFragmentFirst.heightEditText.text.toString()

        if (neckSize.trim().isNotEmpty() && bodySize.trim().isNotEmpty() && height.trim()
                .isNotEmpty()
        ) {
            bindingFragmentFirst.sizeText.visibility = View.VISIBLE
            bindingFragmentFirst.sizeValueText.visibility = View.VISIBLE
            viewModel.getSize(
                neckSize = neckSize.toInt(),
                bodySize = bodySize.toInt(),
                height = height.toInt()
            )
        } else {
            Toast.makeText(requireContext(), R.string.enter_sizes, Toast.LENGTH_SHORT).show()
        }
    }


}