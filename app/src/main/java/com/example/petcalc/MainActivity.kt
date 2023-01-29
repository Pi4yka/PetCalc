package com.example.petcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.petcalc.databinding.ActivityMainBinding
import com.example.petcalc.screen.first.CalculatorFragment
import com.example.petcalc.screen.second.HistoryFragment
import com.example.petcalc.screen.second.HowToFragment
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
            when(it.itemId){
                R.id.bottom_navigationbar_calculator -> setCurrentFragment(CalculatorFragment())
                R.id.bottom_navigationbar_history -> setCurrentFragment(HistoryFragment())
            }
            true
        }

    }

    private fun setCurrentFragment(
        fragment: Fragment
    ) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, fragment)
        commit()
    }
}