package com.example.mytodo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mytodo.model.TodoModel

@Dao
interface TodoDAO{

    @Query("Select * from Todo order by createdDate ASC")
    fun getTodoList() : LiveData<List<TodoModel>>

    @Insert
    fun insertTodo(todoModel : TodoModel)

}