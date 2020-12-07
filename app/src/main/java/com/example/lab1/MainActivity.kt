package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tombol.setOnClickListener {
            if (!editText.text.isNullOrEmpty()) {
                val number = editText.text.toString().toDouble()
                tvRes.text = logCalculation(number).toString()
            }
        }
    }

    private external fun logCalculation(number: Double): Double

    companion object {
        init {
            System.loadLibrary("cpp_code")
        }
    }
}
