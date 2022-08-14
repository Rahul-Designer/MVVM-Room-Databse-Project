package com.example.roommvvmproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context) : UserDatabase{
            if (INSTANCE == null) {
                synchronized(this) {
                    Room.databaseBuilder(
                        context.applicationContext,UserDatabase::class.java,"User_Database")
                        .build().also { INSTANCE = it }
                }
            }
            return INSTANCE!!
        }
    }
}