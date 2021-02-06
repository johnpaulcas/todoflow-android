package com.learn.todoflow.di

import android.app.Application
import androidx.room.Room
import com.learn.todoflow.db.TodoDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author johnpaulcas
 * @since 06/02/2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    fun provideTodoDb(
        app: Application
    ) = Room.databaseBuilder(app, TodoDb::class.java, "todo_database")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideTodoDao(db: TodoDb) = db.todoDao()

}