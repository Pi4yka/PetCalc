package com.example.petcalc

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petcalc.databinding.ActivityMainBinding
import com.example.petcalc.screen.first.FirstFragment
import com.example.petcalc.screen.first.FirstFragmentViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


//TODO: делаем ветку draft от текущего мастера
// Вливаем мастер в девелоп
// В девелопе убираем все лишнее из прилы. Должен остаться только калькулятор
// Клинап реформат рефаторинг
// Дизайн, придумать / спиздить / дождаться пока Антон чета сделает
// Пулл реквест из девелопа в мастер прикрепляенм Антона ревьювером пишем ему в тг+вк+почта+ватсапп чтобы он провел код ревью
// Написать на ридми на гитхаб, 2 скриншота
//


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainBinding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainBinding.root
        setContentView(view)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        val firstFragment = FirstFragment()

        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.calculateIc -> setCurrentFragment(firstFragment)
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