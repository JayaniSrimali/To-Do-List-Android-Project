package com.example.to_dolistapp



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashsceen)
        val thread = object : Thread() {
            override fun run() {
                try {
                    sleep(5000)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    val mainIntent = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(mainIntent)
                }
            }
        }
        thread.start()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}