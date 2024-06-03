package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val userId: Int,
    val username: String,
    val password: String,
    val rating: Double,
    val darkThemeEnabled: Boolean,
    val notificationsEnabled: Boolean,
    val soundEnabled: Boolean
)