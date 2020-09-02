package com.example.mytodo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytodo.R
import com.example.mytodo.model.TodoModel
import com.example.mytodo.view.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.customlayout.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var mTodoListAdapter : TodoListAdapter
    private var mTodoItems : ArrayList<TodoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initAddButton()
    }

    private fun initRecyclerView() {
        mTodoListAdapter = TodoListAdapter(mTodoItems)

        recyclerview_toto_list.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mTodoListAdapter
        }
    }

    private fun initAddButton(){
        button_add_todo.setOnClickListener {
            openAddTodoDialog()
        }
    }

    private fun openAddTodoDialog(){
        val dialogView = layoutInflater.inflate(R.layout.customlayout, null)
        val dialog = AlertDialog.Builder(this)
            .setTitle("추가하기")
            .setView(dialogView)
            .setPositiveButton("확인", { dialogInterface, i ->
                val title = dialogView.edittext_todo_title.text.toString()
                val description = dialogView.edittext_todo_description.text.toString()
                val createdDate = Date().time

                val todoModel = TodoModel(title, description, createdDate)
                mTodoListAdapter.addItem(todoModel)
                mTodoListAdapter.notifyDataSetChanged()
            })
            .setNegativeButton("취소",  null)
            .create()

        dialog.show()
    }


}