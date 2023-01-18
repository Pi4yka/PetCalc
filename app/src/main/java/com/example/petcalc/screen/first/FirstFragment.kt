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
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val bindingFirstFragment get() = _binding!!
    private val viewModel: FirstFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TEST", "Fragment created")
        _binding = FragmentFirstBinding.bind(view)

        val sizeResultObserver = Observer<String> { sizeResult ->
            bindingFirstFragment.sizeValueText.text = sizeResult
        }

        viewModel.sizeResult.observe(viewLifecycleOwner, sizeResultObserver)

        bindingFirstFragment.calcuclateBtn.setOnClickListener { onCalculateClicked() }
    }

    private fun onCalculateClicked() {
        val neckSize = bindingFirstFragment.neckEditText.text.toString()
        val bodySize = bindingFirstFragment.bodyEditText.text.toString()
        val height = bindingFirstFragment.heightEditText.text.toString()

        if (neckSize.trim().isNotEmpty() && bodySize.trim().isNotEmpty() && height.trim()
                .isNotEmpty()
        ) {
            bindingFirstFragment.sizeText.visibility = View.VISIBLE
            bindingFirstFragment.sizeValueText.visibility = View.VISIBLE
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