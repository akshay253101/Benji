package com.example.beetlestance.benji.di.modules.roomDatabaseModule

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.beetlestance.benji.data.RoomApiService
import com.example.beetlestance.benji.model.TodoListData

@Database(entities = [TodoListData::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoProvider(): RoomApiService
}