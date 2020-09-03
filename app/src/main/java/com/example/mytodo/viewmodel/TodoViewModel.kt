package com.example.mytodo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mytodo.model.TodoModel
import com.example.mytodo.repository.TodoRepository

//AndroidViewModel 외에 ViewModel 이란 것도 있는데, ViewModel 에서 Context 가 필요한 경우 AndroidViewModel 클래스를 상속받아 Application 객체를 넘길 것을 권장
//ViewModel 에서 Context                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          를 갖고 있으면 메모리 누수의 원인
class TodoViewModel(application : Application) : AndroidViewModel(application) {

    private var mTodoRepository: TodoRepository
    private var mTodoItems: LiveData<List<TodoModel>>

    init {
        mTodoRepository = TodoRepository(application)
        mTodoItems = mTodoRepository.getTodoList()
    }

    fun insertTodo(todoModel : TodoModel) {
        mTodoRepository.insertTodo(todoModel)
    }

    fun getTodoList() : LiveData<List<TodoModel>> {
        return mTodoItems
    }


}