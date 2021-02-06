package com.learn.todoflow.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learn.todoflow.db.entities.Todo
import kotlinx.coroutines.flow.Flow

/**
 * @author johnpaulcas
 * @since 06/02/2021
 */
@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrInsert(todo: Todo)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM todo_table WHERE id=:id")
    fun getTodo(id: Long): Flow<Todo>

    @Query("SELECT * FROM todo_table")
    fun getAllTodos(): Flow<List<Todo>>

}