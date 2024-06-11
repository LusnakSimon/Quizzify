package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_progress",
    indices = [Index(value = ["userId"]), Index(value = ["questionId"])],
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["userId"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Question::class, parentColumns = ["questionId"], childColumns = ["questionId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class UserProgress(
    @PrimaryKey(autoGenerate = true) val progressId: Int = 0,
    val userId: Int,
    val questionId: Int,
    val isAnswered: Boolean = false
)

