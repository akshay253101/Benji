package com.example.beetlestance.benji.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
*   Model Class for todoListJson
*/
@Entity
data class TodoListData(
    @PrimaryKey val contactId: Int,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "firsName") val firsName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "notes") val notes: String,
    @ColumnInfo(name = "phone") val hone: String
)