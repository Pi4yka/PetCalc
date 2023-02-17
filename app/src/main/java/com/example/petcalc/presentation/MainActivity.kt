package com.example.petcalc.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.petcalc.R
import com.example.petcalc.databinding.ActivityMainBinding
import com.example.petcalc.presentation.screen.calculator.CalculatorFragment
import com.example.petcalc.presentation.screen.history.HistoryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
        setCurrentFragment(CalculatorFragment())

        mainActivityBinding.bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                mainActivityBinding.bottomNavigationBar.selectedItemId -> {}
                R.id.bottom_navigationbar_calculator -> setCurrentFragment(CalculatorFragment())
                R.id.bottom_navigationbar_history -> setCurrentFragment(HistoryFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)  {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}