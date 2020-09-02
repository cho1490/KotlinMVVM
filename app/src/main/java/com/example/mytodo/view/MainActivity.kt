package com.example.mytodo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytodo.R
import com.example.mytodo.model.TodoModel
import com.example.mytodo.view.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var mTodoListAdapter : TodoListAdapter
    private var mTodoItems : ArrayList<TodoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTodoItems.run {
            add(TodoModel("안드로이드 포스팅1", "Kotlin + MVVM + AAC 로 Todo 앱 만들기 - 1", Date().time))
            add(TodoModel("안드로이드 포스팅2", "Kotlin + MVVM + AAC 로 Todo 앱 만들기 - 2", Date().time))
            add(TodoModel("안드로이드 포스팅3", "Kotlin + MVVM + AAC 로 Todo 앱 만들기 - 3", Date().time))
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        mTodoListAdapter = TodoListAdapter(mTodoItems)

        recyclerview_toto_list.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mTodoListAdapter
        }
    }

}