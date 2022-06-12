package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    var runCounter:Boolean = false
    var counter:Int = 0

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG,"Service: onStartCommand. StartID = $startId")
        runCounter = intent!!.getBooleanExtra("runCounter",false)
        counter = intent!!.getIntExtra("counter",0)
        Log.d(TAG,"startStop = $runCounter, counter=$counter")
        val p = Thread {
            while (runCounter) {
                    Log.d(TAG, "counter = $counter")
                    counter++
                    Thread.sleep(500)
                }
            }
        p.start()
        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG,"Service: onDestroy")
        runCounter = false
        super.onDestroy()
    }
}