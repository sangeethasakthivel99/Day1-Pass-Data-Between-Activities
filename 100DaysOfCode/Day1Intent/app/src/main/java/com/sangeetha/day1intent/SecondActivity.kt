package com.sangeetha.day1intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.tv_random_number
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private lateinit var randomText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        randomText = intent.getStringExtra("RandomNumber").toString()
        setRandomNumber()
        setOnClickListener()
    }

    private fun setRandomNumber() {
        tv_random_number.text = randomText
    }

    private fun setOnClickListener() {
        button_back.setOnClickListener {
            sendDataThroughIntent()
        }
    }

    private fun sendDataThroughIntent() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("RandomNumber", RandomNumber.generate().toString())
        setResult(1,intent)
        finish()
    }
}