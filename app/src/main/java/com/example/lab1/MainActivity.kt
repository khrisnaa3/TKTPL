package com.example.lab1

import android.content.Context
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var wifiReceiver: WifiReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiReceiver = WifiReceiver(wifiManager, tvResponse, tvWifi)

        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        applicationContext.registerReceiver(wifiReceiver, intentFilter)

        btnWifi.setOnClickListener {
            tvWifi.text = "Wi-Fi Sniffing..."

            val success = wifiManager.startScan()
            if (!success) {
                tvWifi.text = "Scanning failed"
            }
        }
    }
}
