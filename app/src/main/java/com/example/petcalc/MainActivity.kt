package com.example.petcalc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.petcalc.databinding.ActivityMainBinding
import com.example.petcalc.screen.first.FirstFragment
import com.example.petcalc.screen.second.SecondFragment
import com.example.petcalc.screen.third.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainBinding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
//    private lateinit var bindingBottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainBinding.root
        setContentView(view)
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