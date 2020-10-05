package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    var isExitPressed: Boolean = false
    var isPaused: Boolean = true
    var second: Int = 0
    var minute: Int = 0

    // create runnable infinity loop to count the time
    var timerRunnable: Runnable = Runnable {
        try {
            while (true) {
                sleep(1000)
                runOnUiThread {
                    second++
                    if (second == 60) {
                        minute++
                        second = 0
                    }
                    val minString = if (minute.toString().length > 1) "$minute" else "0$minute"
                    val secString = if (second.toString().length > 1) "$second" else "0$second"

                    textTime.text = "$minString:$secString"
                }
            }
        } catch (err: InterruptedException) {
            println(err)
        }
    }

    private lateinit var timerThread: Thread

    // override android function while state changes
    override fun onRestart() {
        super.onRestart()
        Log.d("Restart", "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Resume", "onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Stop", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Destroy", "onDestroy()")
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Press EXIT BUTTON to exit", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Start", "onStart()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Pause", "onPause()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Create", "onCreate()")

        // Start function when start button pressed, and resume time when pause button pressed
        // Interrupt the thread to pause the timer
        bt_start_pause.setOnClickListener {
            if (isPaused) {
                isPaused = false
                bt_start_pause.setImageResource(R.drawable.ic_pause)
                timerThread = Thread(timerRunnable)
                timerThread.start()
            } else {
                isPaused = true
                bt_start_pause.setImageResource(R.drawable.ic_play)
                timerThread.interrupt()
            }
        }

        // Reset all time value then interrupt the timerThread
        bt_reset.setOnClickListener {
            minute = 0
            second = 0
            if (!isPaused) {
                timerThread.interrupt()
                bt_start_pause.setImageResource(R.drawable.ic_play)
                isPaused = true
            }
            textTime.text = "00:00"
        }

        // Exit button to exit the app
        // Exit should click the button twice
        bt_exit.setOnClickListener {
            if (isExitPressed) {
                isExitPressed = false
                super.onBackPressed()
            } else {
                Toast.makeText(this, "Press once again to exit", Toast.LENGTH_LONG).show()
                isExitPressed = true
            }
        }
    }
}