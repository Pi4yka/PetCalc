package com.example.petcalc.screen.first

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentCalculatorBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CalculatorFragment : Fragment(R.layout.fragment_calculator) {

    private var _binding: FragmentCalculatorBinding? = null
    private val bindingCalculatorFragment get() = _binding!!
    private val viewModel: CalculatorFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TEST", "Fragment created")
        _binding = FragmentCalculatorBinding.bind(view)

        val sizeResultObserver = Observer<String> { sizeResult ->
            bindingCalculatorFragment.sizeValueText.text = sizeResult
        }

        viewModel.sizeResult.observe(viewLifecycleOwner, sizeResultObserver)

        bindingCalculatorFragment.calculateBtn.setOnClickListener { onCalculateClicked() }
    }

    private fun onCalculateClicked() {
        val neckSize = bindingCalculatorFragment.neckTextInput.editText?.text.toString()
        val bodySize = bindingCalculatorFragment.bodyTextInput.editText?.text.toString()
        val height = bindingCalculatorFragment.heightTextInput.editText?.text.toString()

        if (neckSize.trim().isNotEmpty() && bodySize.trim().isNotEmpty() && height.trim()
                .isNotEmpty()
        ) {
            bindingCalculatorFragment.sizeText.visibility = View.VISIBLE
            bindingCalculatorFragment.sizeValueText.visibility = View.VISIBLE
            bindingCalculatorFragment.relativeResultBlock.visibility = View.VISIBLE
            viewModel.getSize(
                neckSize = neckSize.toInt(),
                bodySize = bodySize.toInt(),
                height = height.toInt()
            )
        } else {
            Toast.makeText(requireContext(), R.string.enter_sizes, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.sizeResult.removeObservers(this)
        this._binding = null
    }


}