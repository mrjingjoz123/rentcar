package com.s59161111.rentcar.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_book_table")
data class Book(

    @PrimaryKey(autoGenerate = true)
    var bookId: Long = 0L,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "bike")
    val bike: String = ""


)