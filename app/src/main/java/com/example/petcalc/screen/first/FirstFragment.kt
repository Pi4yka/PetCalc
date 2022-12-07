package com.example.petcalc.screen.first

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var bindingFragmentFirst: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFragmentFirst = FragmentFirstBinding.bind(view)
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
            bindingFragmentFirst.sizeValueText.text = getSizeValue(
                neckSize = neckSize.toInt(),
                bodySize = bodySize.toInt(),
                height = height.toInt()
            )
        } else {
            Toast.makeText(requireContext(), R.string.enter_sizes, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSizeValue(
        neckSize: Int,
        bodySize: Int,
        height: Int
    ): String {
        return when {
            bodySize in 28..36 || neckSize in 18..22 && height >= 20 -> "XS"
            bodySize in 36..40 || neckSize in 22..26 && height >= 26 -> "S"
            bodySize in 40..46 || neckSize in 26..30 && height >= 30 -> "M"
            bodySize in 46..50 || neckSize in 30..34 && height >= 36 -> "L"
            bodySize >= 50 || neckSize >= 34 && height >= 40 -> "XL"
            else -> "Не могу вычислить"
        }
    }
}