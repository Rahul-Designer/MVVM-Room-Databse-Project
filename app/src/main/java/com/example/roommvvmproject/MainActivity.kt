package com.example.roommvvmproject

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roommvvmproject.Adapter.UserAdapter
import com.example.roommvvmproject.Model.UserViewModel
import com.example.roommvvmproject.Model.UserViewModelFactory
import com.example.roommvvmproject.data.User
import com.example.roommvvmproject.data.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_box.*

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user_recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = UserAdapter(this)
        user_recyclerview.adapter = adapter

        val dao = UserDatabase.getDatabase(applicationContext).userDao()
        val repository = UserRepository(dao)
        userViewModel =
            ViewModelProvider(this, UserViewModelFactory(repository)).get(UserViewModel::class.java)

//        userViewModel.getUser().observe(this, Observer {
//            adapter.setListData(ArrayList(it))
//            adapter.notifyDataSetChanged()
//        })
        add.setOnClickListener {
            val builder = Dialog(this)
            builder.setCancelable(true)
            builder.setTitle("Add")
            builder.setContentView(R.layout.add_dialog_box)
            builder.show()
            val name = builder.userName.text.toString()
            val number = builder.userNumber.text.toString()
            builder.addUser.setOnClickListener{
                Log.d("MAIN",name.toString())
                builder.dismiss()
            }
        }

        }
    }