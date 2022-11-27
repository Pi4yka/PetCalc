package com.example.petcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.calculateIc -> setCurrentFragment(firstFragment)
                R.id.listIc -> setCurrentFragment(secondFragment)
                R.id.diabloIc -> setCurrentFragment(thirdFragment)
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