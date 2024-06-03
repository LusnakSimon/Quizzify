package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgress(
    @PrimaryKey val progressId: Int,
    val userId: Int,
    val categoryId: Int,
    val progress: Int
)