package com.learn.todoflow.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learn.todoflow.db.dao.TodoDao
import com.learn.todoflow.db.entities.Todo

/**
 * @author johnpaulcas
 * @since 06/02/2021
 */
@Database(
    entities = [Todo::class],
    version = 1
)
abstract class TodoDb: RoomDatabase() {

    abstract fun todoDao(): TodoDao

}