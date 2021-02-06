package com.learn.todoflow.ui.todolist

import android.view.View
import androidx.fragment.app.viewModels
import com.learn.todoflow.R
import com.learn.todoflow.base.BaseFragment
import com.learn.todoflow.databinding.FragmentTodoListBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author johnpaulcas
 * @since 06/02/2021
 */
@AndroidEntryPoint
class TodoListFragment: BaseFragment(R.layout.fragment_todo_list) {

    private val viewModel: TodoListViewModel by viewModels()
    private var viewBinding: FragmentTodoListBinding? = null

    override fun onBindViewResource(view: View) {
        viewBinding = FragmentTodoListBinding.bind(view)
    }

    override fun init() {

    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

}