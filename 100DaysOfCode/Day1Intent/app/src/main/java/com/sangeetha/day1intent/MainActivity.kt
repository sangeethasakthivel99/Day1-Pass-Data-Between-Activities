package com.sangeetha.day1intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRandomNumber()
        setOnClickListener()
    }

    private fun setRandomNumber() {
        tv_random_number.text = RandomNumber.generate().toString()
    }

    private fun setOnClickListener() {
        button_next.setOnClickListener {
            sendDataThroughIntent()
        }
    }

    private fun sendDataThroughIntent() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("RandomNumber", tv_random_number.text)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            tv_random_number.text = data?.getStringExtra("RandomNumber")
        }
    }
}