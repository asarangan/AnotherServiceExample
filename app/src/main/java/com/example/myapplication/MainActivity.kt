package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

val TAG = "myService"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent:Intent = Intent(this,MyService::class.java)

        //Start Service Button
        findViewById<Button>(R.id.btnStartService).setOnClickListener {
            startService(intent)
        }

        //Stop Service Button
        findViewById<Button>(R.id.btnStopService).setOnClickListener {
            stopService(intent)
        }

        //Send button
        findViewById<Button>(R.id.btnSend).setOnClickListener {
            val value:Int = findViewById<EditText>(R.id.etValue).text.toString().toInt()
            intent.putExtra("counter",value)
            startService(intent)
        }

        //Start Counter Button
        findViewById<Button>(R.id.btnStartCounter).setOnClickListener {
            intent.putExtra("runCounter",true)
            startService(intent)
        }

        //Stop Counter Button
        findViewById<Button>(R.id.btnStopCounter).setOnClickListener {
            intent.putExtra("runCounter",false)
            startService(intent)
        }
    }
}