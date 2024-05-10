package com.example.to_dolistapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private var todo: List<TODO>,context: Context) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
        private val db : TODODatabaseHelper = TODODatabaseHelper(context)

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTextView:  TextView = itemView.findViewById(R.id.titleTextView)
        val contextTextView:  TextView = itemView.findViewById(R.id.contentTextView)
        val updateButton:  ImageView= itemView.findViewById(R.id.updateButton)
        val deleteButton:  ImageView= itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int = todo.size



    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todo[position]
        holder.titleTextView.text = todo.title
        holder.contextTextView.text = todo.content

        holder.updateButton.setOnClickListener {
            val intent =   Intent(holder.itemView.context,UpdateActivity::class.java).apply {
                putExtra("todo_id",todo.id)
            }
            holder.itemView.context.startActivity(intent)

        }

        holder.deleteButton.setOnClickListener {
            db.deleteTodo(todo.id)
            refreshData(db.getAllTodoList())
            Toast.makeText(holder.itemView.context," Todo deleted ",Toast.LENGTH_SHORT).show()
        }

    }
    fun refreshData(newTODO: List<TODO>){
        todo = newTODO
        notifyDataSetChanged()

    }

}