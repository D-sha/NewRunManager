package com.example.runmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
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
        list.onItemClickListener  = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent :Intent = Intent(applicationContext, ListDetail::class.java)
            startActivity(intent)
        }

    }
}