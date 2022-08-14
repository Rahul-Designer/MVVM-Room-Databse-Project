package com.example.roommvvmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.roommvvmproject.Model.UserViewModel
import com.example.roommvvmproject.Model.UserViewModelFactory
import com.example.roommvvmproject.data.UserDatabase

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao =UserDatabase.getDatabase(applicationContext).userDao()
        val repository =UserRepository(dao)
        userViewModel = ViewModelProvider(this,UserViewModelFactory(repository)).get(UserViewModel::class.java)


    }
}