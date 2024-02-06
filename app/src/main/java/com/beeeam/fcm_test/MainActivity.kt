package com.beeeam.fcm_test // ktlint-disable package-name

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.beeeam.fcm_test.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFCM()
    }

    private fun initFCM() {
        // Firebase Message Token 확인하는 동작
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("token", task.result)
                binding.text.text = task.result
            }
        }
    }
}
