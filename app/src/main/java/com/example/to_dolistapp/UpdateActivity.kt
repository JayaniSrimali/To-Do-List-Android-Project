package com.example.to_dolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.widget.Toast
import com.example.to_dolistapp.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var db:TODODatabaseHelper
    private  var todoId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_update)

        db = TODODatabaseHelper(this)

        todoId = intent.getIntExtra("todo_id",-1)
        if (todoId == -1){
            finish()
            return
        }

        val todo = db.getTodoByID(todoId)
        binding.updatetitleEditText.setText(todo.title)
        binding.updatecontentEditText.setText(todo.content)

        binding.updateButton.setOnClickListener {
            val newTitle = binding.updatecontentEditText.text.toString()
            val  newContent = binding.updatecontentEditText.text.toString()
            val updateTodo = TODO(todoId,newTitle,newContent)
            db.updateTodo(updateTodo)
            finish()
            Toast.makeText(this,"Changes saved",Toast.LENGTH_SHORT).show()
        }

    }
}