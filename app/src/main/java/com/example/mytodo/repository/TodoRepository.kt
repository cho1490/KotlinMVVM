package com.example.mytodo.repository


import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mytodo.database.TodoDAO
import com.example.mytodo.database.TodoDatabase
import com.example.mytodo.model.TodoModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class TodoRepository(application : Application){

    private var mTodoDatabase : TodoDatabase
    private var mTodoDAO : TodoDAO
    private var mTodoItems : LiveData<List<TodoModel>>

    init {
        mTodoDatabase = TodoDatabase.getInstance(application)
        mTodoDAO = mTodoDatabase.todoDao()
        mTodoItems = mTodoDAO.getTodoList()
    }

    fun getTodoList() : LiveData<List<TodoModel>>{
        return mTodoItems
    }


    fun insertTodo(todoModel : TodoModel){
        val compositeDisposable : CompositeDisposable? = null
        val disposable : Disposable = Single.just(todoModel)
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTodoDAO.insertTodo(todoModel)
            }, {
                //error
            })

        compositeDisposable!!.add(disposable)
        disposable.addTo(compositeDisposable)

        compositeDisposable.dispose();
    }

}