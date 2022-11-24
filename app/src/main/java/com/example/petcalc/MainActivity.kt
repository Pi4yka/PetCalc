package com.example.petcalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var calcButton: Button
    private lateinit var neckET: EditText
    private lateinit var bodyET: EditText
    private lateinit var heightET: EditText
    private lateinit var sizeTextView: TextView
    private lateinit var sizeValueTextView: TextView
    private lateinit var dogeImageView: ImageView
    private lateinit var bottomNavBar: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcButton = findViewById(R.id.calcuclateBtn)
        sizeTextView = findViewById(R.id.sizeText)
        sizeValueTextView = findViewById(R.id.sizeValueText)
        neckET = findViewById(R.id.neckEditText)
        bodyET = findViewById(R.id.bodyEditText)
        heightET = findViewById(R.id.heightEditText)
        dogeImageView = findViewById(R.id.dogeImageView)
        bottomNavBar = findViewById(R.id.bottomNavBar)

        dogeImageView.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            this.startActivity(intent)
        }
        calcButton.setOnClickListener { onCalculateClicked() }

        var firstFragment = FirstFragment()
        var secondFragment = SecondFragment()
        var thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)
        bottomNavBar.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.homeIc->setCurrentFragment(firstFragment)
                R.id.personIc->setCurrentFragment(secondFragment)
                R.id.settingsIc->setCurrentFragment(thirdFragment)
            }
            true
        }
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
            Toast.makeText(applicationContext, R.string.enter_sizes, Toast.LENGTH_SHORT).show()
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

    private fun setCurrentFragment(
        fragment: Fragment
    )= supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}