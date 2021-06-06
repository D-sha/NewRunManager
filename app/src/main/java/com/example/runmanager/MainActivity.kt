package com.example.runmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = arrayOf("1", "2", "3")
        val list = findViewById<ListView>(R.id.list)
        val adapter : ArrayAdapter<*>
        adapter  = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        list.adapter = adapter
    }
}