package com.brainerx.githublesson

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.brainerx.githublesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val thread = Thread {
            try {
                Thread.sleep(2000) // 2 seconds
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                // Switch to MainActivity
                runOnUiThread {
                    val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                    startActivity(intent)
                    finish() // Close splash so it won’t come back
                }
            }
        }
        thread.start()

    }
}