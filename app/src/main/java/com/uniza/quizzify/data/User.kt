package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int = 0,
    val username: String,
    val password: String,
    val rating: Int = 0,
    val darkMode: Boolean = false,
    val notifications: Boolean = false,
    val sound: Boolean = false,
    val profilePicture: String? = null
)