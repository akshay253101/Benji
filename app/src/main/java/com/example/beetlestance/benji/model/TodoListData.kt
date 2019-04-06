package com.example.beetlestance.benji.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
*   Model Class for todoListJson
*/
@Entity
data class TodoListData(
    @PrimaryKey var contactId: Int,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "firsName") var firsName: String,
    @ColumnInfo(name = "lastName") var lastName: String,
    @ColumnInfo(name = "notes") var notes: String,
    @ColumnInfo(name = "phone") var phone: String
)