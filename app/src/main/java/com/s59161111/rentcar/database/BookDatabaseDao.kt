package com.s59161111.rentcar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao

interface BookDatabaseDao  {

    @Insert
    fun insert(book: Book)

    @Update
    fun update(book: Book)

    @Query("SELECT * from data_book_table WHERE bookId = :key")
    fun get(key: Long): Book?

    @Query("DELETE FROM data_book_table")
    fun clear()

    @Query("SELECT * FROM data_book_table ORDER BY bookId DESC LIMIT 1")
    fun getToStarted(): Book?

    @Query("SELECT * FROM data_book_table ORDER BY bookId DESC")
    fun getAll(): LiveData<List<Book>>


}