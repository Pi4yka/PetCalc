package com.example.petcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var but_calc: Button
    lateinit var neck: EditText
    lateinit var body: EditText
    lateinit var height: EditText
    lateinit var textsize: TextView
    lateinit var size_net: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but_calc = findViewById(R.id.Calculate_but)
        textsize = findViewById(R.id.Size_pet)
        size_net = findViewById(R.id.Sizes)
        neck = findViewById(R.id.Edit_Neck)
        body = findViewById(R.id.Edit_Body)
        height = findViewById(R.id.Edit_Height)

        but_calc.setOnClickListener {

            size_net.text = set_calculate()

        }
    }

    private fun set_calculate(): String? {
        val n = neck.text.toString()
        val b = body.text.toString()
        val h = height.text.toString()

        if (n.trim().isNotEmpty() && b.trim().isNotEmpty() && h.trim().isNotEmpty()) {
            textsize.text = "Size your pet" // С visibility не разобрался до конца, поэтому костыль
            when {
                b.toInt() in 28..36 && n.toInt() in 18..22 && h.toInt() >= 20 -> return "XS"
                b.toInt() in 36..40 && n.toInt() in 22..26 && h.toInt() >= 26 -> return "S"
                b.toInt() in 40..46 && n.toInt() in 26..30 && h.toInt() >= 30 -> return "M"
                b.toInt() in 46..50 && n.toInt() in 30..34 && h.toInt() >= 36 -> return "L"
                b.toInt() >= 50 && n.toInt() >= 34 && h.toInt() >= 40 -> return "XL"
                else -> return "Error37"
            }
        } else {
            val text_alarm = "Введите все размеры!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text_alarm, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)  // Я пытался вывести через тост, тоже не работает, буду искать еще инфу
            return null
        }

    }

}