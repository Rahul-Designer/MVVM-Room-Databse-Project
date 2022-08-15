package com.example.roommvvmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roommvvmproject.Adapter.UserAdapter
import com.example.roommvvmproject.Model.UserViewModel
import com.example.roommvvmproject.Model.UserViewModelFactory
import com.example.roommvvmproject.data.User
import com.example.roommvvmproject.data.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrUser = ArrayList<User>()

        user_recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(this, arrUser)
        user_recyclerview.adapter = adapter

        val dao = UserDatabase.getDatabase(applicationContext).userDao()
        val repository = UserRepository(dao)
        userViewModel =
            ViewModelProvider(this, UserViewModelFactory(repository)).get(UserViewModel::class.java)
    }

}