package com.learn.todoflow.ui.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.checkbox.MaterialCheckBox
import com.learn.todoflow.R
import com.learn.todoflow.db.entities.Todo

/**
 * @author johnpaulcas
 * @since 06/02/2021
 */
class TodoAdapter(
    private val onClick: (Todo) -> Unit
): ListAdapter<Todo, TodoAdapter.TodoViewHolder>(TodoDiffCallback) {

    class TodoViewHolder(itemView: View, val onClick: (Todo) -> Unit) :
            RecyclerView.ViewHolder(itemView) {
        private val todoName: AppCompatTextView = itemView.findViewById(R.id.todoName)
        private val todoCheckBox: MaterialCheckBox = itemView.findViewById(R.id.todoCheckBox)
        private var currentTodo: Todo? = null

        init {
            itemView.setOnClickListener {
                currentTodo?.let{
                    onClick(it)
                }
            }
        }

        fun bind(todo: Todo) {
            currentTodo = todo
            todoName.text = todo.name
            todoCheckBox.isChecked = todo.isChecked
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bind(todo)
    }

}

object TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }

}