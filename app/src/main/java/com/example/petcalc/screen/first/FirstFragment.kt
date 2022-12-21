package com.example.petcalc.screen.first

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var bindingFragmentFirst: FragmentFirstBinding
    private lateinit var vm: FirstFragmentViewModel

    // Написать вью модель под первый фрагмент FirstViewModel ----

    // сделать в ней метод getSizeValue в viewModelScope ----
    // заинжектить въюмодель в фаргмент
    // по клику вызвать метод из вьюмодели
    // Посмотреть видосы про Solid!!!, Dependency Injection (DI) (HILT)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TEST", "Fragment created")
        bindingFragmentFirst = FragmentFirstBinding.bind(view)
        bindingFragmentFirst.calcuclateBtn.setOnClickListener { onCalculateClicked() }
        vm = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)
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
            bindingFragmentFirst.sizeValueText.text = vm.getSize(
                neckSize = neckSize.toInt(),
                bodySize = bodySize.toInt(),
                height = height.toInt()
            ).toString()
        } else {
            Toast.makeText(requireContext(), R.string.enter_sizes, Toast.LENGTH_SHORT).show()
        }
    }



}