package com.example.petcalc

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.petcalc.model.Dog

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var calcButton: Button
    private lateinit var neckET: EditText
    private lateinit var bodyET: EditText
    private lateinit var heightET: EditText
    private lateinit var sizeTextView: TextView
    private lateinit var sizeValueTextView: TextView
    private lateinit var dogeImageView: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calcButton = view.findViewById(R.id.calcuclateBtn)
        sizeTextView = view.findViewById(R.id.sizeText)
        sizeValueTextView = view.findViewById(R.id.sizeValueText)
        neckET = view.findViewById(R.id.neckEditText)
        bodyET = view.findViewById(R.id.bodyEditText)
        heightET = view.findViewById(R.id.heightEditText)

        calcButton.setOnClickListener { onCalculateClicked() }
    }


    private fun onCalculateClicked() {
        val neckSize = neckET.text.toString()
        val bodySize = bodyET.text.toString()
        val height = heightET.text.toString()

        if (neckSize.trim().isNotEmpty() && bodySize.trim().isNotEmpty() && height.trim()
                .isNotEmpty()
        ) {
            sizeTextView.visibility = View.VISIBLE
            sizeValueTextView.visibility = View.VISIBLE
            sizeValueTextView.text = getSizeValue(
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