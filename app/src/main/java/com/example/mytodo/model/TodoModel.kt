package com.example.mytodo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo")
data class TodoModel (

    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String,

    //https://doitddo.tistory.com/54?category=855312
    var description: String,


    var createdDate: Long
){}
