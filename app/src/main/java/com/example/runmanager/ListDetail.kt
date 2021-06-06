package com.example.runmanager

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.runmanager.databinding.ActivityListDetailBinding

class ListDetail : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityListDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_list_detail)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        val data = intent.extras?.getInt("position")
        var array: Array<String>
        if (data == 0){
            array = arrayOf("A", "B", "C")
        }
        if (data == 1){
            array = arrayOf("D", "E", "F")
        }else if (data == 2){
            array = arrayOf("G", "H", "I")
        }else{
            array = arrayOf("Z", "Z", "Z")
        }
        val list = findViewById<ListView>(R.id.nestedlist)
        val adapter : ArrayAdapter<*>
        adapter  = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        list.adapter = adapter
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent: Intent = Intent(applicationContext, DetailsActivity::class.java)
            intent.putExtra("jobId", position)
            startActivity(intent)
        }
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_list_detail)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}