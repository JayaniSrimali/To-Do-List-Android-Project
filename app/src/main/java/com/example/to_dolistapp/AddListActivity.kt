package com.example.to_dolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.to_dolistapp.databinding.ActivityAddListBinding
import com.example.to_dolistapp.databinding.ActivityMainBinding

class AddListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddListBinding
    private lateinit var db:TODODatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TODODatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val todo =  TODO(0,title,content)
            db.insertTodo(todo)
            Toast.makeText(this,"To to saved",Toast.LENGTH_SHORT).show()
        }
    }
}