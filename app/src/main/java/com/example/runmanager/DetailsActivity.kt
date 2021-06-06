package com.example.runmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val textViewJobName = findViewById<TextView>(R.id.textViewJobName)

        val jobId = intent.extras?.getInt("jobId")

        if (jobId == 1){
            textViewJobName.text = "Im number one"
        } else {
            textViewJobName.text = "who knows"
        }
    }
}