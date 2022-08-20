package com.example.roommvvmproject

import androidx.lifecycle.LiveData
import com.example.roommvvmproject.data.User
import com.example.roommvvmproject.data.UserDao

class UserRepository(private val userDao: UserDao) {

    fun getUser() :LiveData<List<User>>{
        return userDao.getUser()
    }

    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
}