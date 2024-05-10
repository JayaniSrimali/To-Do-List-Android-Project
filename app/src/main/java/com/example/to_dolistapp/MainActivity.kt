package com.example.to_dolistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_dolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private lateinit var db : TODODatabaseHelper
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TODODatabaseHelper(this)
        todoAdapter = TodoAdapter(db.getAllTodoList(),this)

        binding.todoRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.todoRecyclerView.adapter = todoAdapter

        binding.addButton.setOnClickListener{
            val  intent =   Intent(this,AddListActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        todoAdapter.refreshData(db.getAllTodoList())
    }
}