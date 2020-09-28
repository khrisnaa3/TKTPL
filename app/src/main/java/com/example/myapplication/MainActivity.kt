package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            hasil.text = multiply(panjang.text.toString(), lebar.text.toString())
        }
    }

    fun multiply(a: String, b: String): String {
        return ((a.toDoubleOrNull() ?: 0.0) * (b.toDoubleOrNull() ?: 0.0)).toString()
    }
}