package com.example.petcalc.presentation.screen.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentCalculatorBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment : Fragment(R.layout.fragment_calculator) {

    private var _binding: FragmentCalculatorBinding? = null
    private val bindingCalculatorFragment get() = _binding!!
    private val viewModel: CalculatorFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCalculatorBinding.bind(view)

        val sizeResultObserver = Observer<Int> { sizeResult ->
            bindingCalculatorFragment.sizeValueText.text = getString(sizeResult)
        }

        viewModel.sizeResult.observe(viewLifecycleOwner, sizeResultObserver)
        bindingCalculatorFragment.calculateBtn.setOnClickListener { onCalculateClicked() }
        bindingCalculatorFragment.questionButtonView.setOnClickListener { showDialogFragment() }
    }

    private fun isInputsEmpty(): Boolean =
        bindingCalculatorFragment.neckTextInput.text.toString().isNotEmpty() &&
                bindingCalculatorFragment.bodyTextInput.text.toString().trim().isNotEmpty() &&
                bindingCalculatorFragment.heightTextInput.text.toString().trim().isNotEmpty()

    private fun onCalculateClicked() {
        if (isInputsEmpty()) {
            bindingCalculatorFragment.sizeMainText.visibility = View.VISIBLE
            bindingCalculatorFragment.sizeValueText.visibility = View.VISIBLE
            bindingCalculatorFragment.resultContainer.visibility = View.VISIBLE
            viewModel.calculateSize(
                neckSize = bindingCalculatorFragment.neckTextInput.text.toString().toInt(),
                bodySize = bindingCalculatorFragment.bodyTextInput.text.toString().toInt(),
                bodyHeight = bindingCalculatorFragment.heightTextInput.text.toString().toInt()
            )
        } else {
            Toast.makeText(requireContext(), R.string.enter_sizes, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDialogFragment() {
        val dialog = BottomSheetDialog(this.requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(R.layout.fragment_bottomsheet)
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.sizeResult.removeObservers(this)
        this._binding = null
    }

}