package com.example.lab1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.lang.Exception

class WifiReceiver(var wifiManager: WifiManager, var tvRes: TextView, var tvWifi: TextView) :
    BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context?, intent: Intent?) {

        val success = intent?.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
        if (success!!) {
            var wifiResult = ""
            wifiManager.scanResults.forEach {
                wifiResult += "<SSID> ${it.SSID} </SSID>\n"
            }
            try {
                val reqQueue = Volley.newRequestQueue(context)
                val url = "https://6ec557b985307cbe5c7564ac497eb39e.m.pipedream.net"
                val postJsonObj = JSONObject()
                postJsonObj.put("wifi_result", wifiResult)

                val jsonReq = JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    postJsonObj,
                    Response.Listener<JSONObject> { response ->
                        tvRes.text = "Response: ${response.toString()}"
                    },
                    Response.ErrorListener {
                        tvRes.text = "Response Error"
                    })

                reqQueue.add(jsonReq)
                tvWifi.text = wifiResult
            } catch (e: Exception) {
                val err = e.toString()
                tvWifi.text = "Error: ${err}"
            }
        } else {
            tvWifi.text = "FAILED"
        }
    }

}