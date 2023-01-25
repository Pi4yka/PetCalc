package com.example.petcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.petcalc.databinding.ActivityMainBinding
import com.example.petcalc.screen.first.CalculatorFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityBinding.root
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