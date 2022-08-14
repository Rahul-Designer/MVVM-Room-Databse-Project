package com.example.roommvvmproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_details")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: String
)
