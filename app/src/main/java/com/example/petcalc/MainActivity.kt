package com.example.petcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.petcalc.databinding.ActivityMainBinding
import com.example.petcalc.screen.first.CalculatorFragment
import dagger.hilt.android.AndroidEntryPoint


//TODO: Клинап реформат рефаторинг
// Дизайн, придумать / спиздить / дождаться пока Антон чета сделает
// Пулл реквест из девелопа в мастер прикрепляенм Антона ревьювером пишем ему в тг+вк+почта+ватсапп чтобы он провел код ревью
// Написать ридми на гитхаб, 2 скриншота
//


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainActivityBinding.root
        setContentView(view)
        val calculatorFragment = CalculatorFragment()
        setCurrentFragment(calculatorFragment)
    }

    private fun setCurrentFragment(
        fragment: Fragment
    ) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, fragment)
        commit()
    }
}