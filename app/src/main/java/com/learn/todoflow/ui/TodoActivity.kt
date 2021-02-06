package com.learn.todoflow.ui

import android.os.Bundle
import android.view.View
import com.learn.todoflow.R
import com.learn.todoflow.base.BaseActivity
import com.learn.todoflow.databinding.ActivityTodoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoActivity : BaseActivity() {

    lateinit var todoViewBinding: ActivityTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
    }

    override fun onBindViewResource(): View {
        todoViewBinding = ActivityTodoBinding.inflate(layoutInflater)
        return todoViewBinding.root
    }

    override fun init() {

    }
}