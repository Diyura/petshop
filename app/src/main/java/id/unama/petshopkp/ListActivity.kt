package id.unama.petshopkp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import id.unama.petshopkp.adapter.TodoAdapter
import id.unama.petshopkp.model.Todo
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    private var todosData = mutableListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
//        todoAdapter = TodoAdapter(mutableListOf())
//
//        rvTodoItems.adapter = todoAdapter
//        rvTodoItems.layoutManager = LinearLayoutManager(this)

        todoAdapter = TodoAdapter(todosData)
        val rvTodo = findViewById<RecyclerView>(R.id.rvTodoItems)
        rvTodo.adapter = todoAdapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        getTodoList()
























        btnAddTodo.setOnClickListener {
            val etTitleTodo = findViewById<EditText>(R.id.etTodoTitle)
            if (etTitleTodo.text.isNotEmpty()) {
                val toDO = Todo(etTitleTodo.text.toString())
                etTitleTodo.text.clear()
                Firebase.database.getReference("todoList").child(Firebase.auth.currentUser!!.uid)
                    .push()
                    .setValue(toDO).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Todo berhasil ditambahkan", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(this, "Todo Gagal ditambahkan", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            } else {
                Toast.makeText(this, "TODO Title tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
        btnDeleteDoneTodo.setOnClickListener {

        }
    }

    private fun getTodoList() {
        Firebase.database.getReference("todoList").child(Firebase.auth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        if(todosData.isEmpty()) {
                            for (todo in snapshot.children) {
                                todosData.add(
                                    Todo(
                                        todo.child("title").value as String,
                                        todo.child("checked").value as Boolean
                                    )
                                )
                                todoAdapter.notifyItemInserted(todosData.size - 1)
                            }
                        } else {
                            with(snapshot.children.last()) {
                                todosData.add(
                                    Todo(
                                        this.child("title").value as String,
                                        this.child("checked") as Boolean
                                    )
                                )
                            }
                            todoAdapter.notifyItemInserted(todosData.size - 1)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@ListActivity, "Anda Jembud", Toast.LENGTH_SHORT).show()
                }

            })
    }
}