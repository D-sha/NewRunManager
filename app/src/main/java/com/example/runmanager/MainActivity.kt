package com.example.runmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val array = arrayOf("one", "two", "three")

        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(array)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = manager
            adapter =  myAdapter
        }

        /*val list = findViewById<ListView>(R.id.list)
        val adapter : ArrayAdapter<*>
        val runList :LiveData<List<Run>> = arrayOf(RMViewModel)
        for ()
        adapter  = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        list.adapter = adapter
        list.onItemClickListener  = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent :Intent = Intent(applicationContext, ListDetail::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }*/

    }
    class MyAdapter(private val myDataSet : Array<String>):
        RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
            fun bind(text: String){
                val tv = view.findViewById<TextView>(R.id.textView)
                tv.text = text
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val vh = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
            return ViewHolder(vh)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(myDataSet[position])
        }

        override fun getItemCount(): Int {
            return myDataSet.size
        }

    }
}