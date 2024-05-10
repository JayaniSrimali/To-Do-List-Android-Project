package com.example.to_dolistapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private var todo: List<TODO>,context: Context) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTextView:  TextView = itemView.findViewById(R.id.titleTextView)
        val contextTextView:  TextView = itemView.findViewById(R.id.contentTextView)
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

    }
    fun refreshData(newTODO: List<TODO>){
        todo = newTODO
        notifyDataSetChanged()
    }

}