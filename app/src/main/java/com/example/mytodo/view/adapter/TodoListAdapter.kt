package com.example.mytodo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.R
import com.example.mytodo.model.TodoModel
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoListAdapter(var todoItems : ArrayList<TodoModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val todoModel = todoItems[position]

        val todoViewHolder = holder as TodoViewHolder
        todoViewHolder.bind(todoModel)
    }

    class TodoViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val title = view.tv_todo_title
        val description = view.tv_todo_description
        val createdData = view.tv_todo_created_date

        fun bind(todoModel : TodoModel){
            title.text = todoModel.title
            description.text = todoModel.description
            createdData.text =todoModel.createdDate.toString()
        }

    }

}