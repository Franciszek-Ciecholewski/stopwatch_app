package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    /*
    override fun onStart() {
        super.onStart()
        timer.start()
    }

     */

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    fun takeContent(view: View) {
        val input_field = findViewById<EditText>(R.id.editTextTime)
        val input_value = input_field.text.toString().toLong() * 1_000
        val textView: TextView = findViewById<TextView>(R.id.textView) as TextView
        input_field.setText("")

        timer = object: CountDownTimer(input_value, 100) {
            override fun onTick(remaining: Long) {
                textView.setText(remaining.toString())
            }

            override fun onFinish() {
                textView.setText("Done!")
            }
        }
        timer.start()
    }
}