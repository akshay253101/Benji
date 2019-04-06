package com.example.beetlestance.benji.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.beetlestance.benji.model.TodoListData
import io.reactivex.Observable

@Dao
interface RoomApiService {

    @Query("Select * from todoListData")
    fun getAll(): Observable<List<TodoListData>>

    @Insert
    fun insertAll(vararg todoListData: TodoListData)

    @Delete
    fun deleteAll(todoListData: TodoListData)
}