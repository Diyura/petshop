package id.unama.petshopkp.adapter

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.unama.petshopkp.R
import id.unama.petshopkp.model.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            if (todos.isNotEmpty()) {
                tvTodoTitle.text = todos[position].title
                cbDone.isChecked = todos[position].isChecked!!

                toggleStrikeThrough(tvTodoTitle, todos[position].isChecked!!)
                cbDone.setOnCheckedChangeListener { _, isChecked ->
                    toggleStrikeThrough(tvTodoTitle, isChecked)
                    todos[position].isChecked = !todos[position].isChecked!!
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}