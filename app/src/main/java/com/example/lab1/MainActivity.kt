package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0
        tombol.setOnClickListener {
            counter++
            if (counter%2 == 0) {
                teks.setText("I'm Khrisna")
            } else {
                teks.setText("Hello World!")
            }
        }
    }
}
