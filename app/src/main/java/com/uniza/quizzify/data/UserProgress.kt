package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_progress",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["userId"], childColumns = ["userId"]),
        ForeignKey(entity = Category::class, parentColumns = ["categoryId"], childColumns = ["categoryId"])
    ]
)
data class UserProgress(
    @PrimaryKey(autoGenerate = true) val progressId: Int = 0,
    val userId: Int,
    val categoryId: Int,
    val progress: Float = 0.0f
)