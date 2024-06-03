package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answers")
data class Answer(
    @PrimaryKey val answerId: Int,
    val questionId: Int,
    val answerText: String,
    val isCorrect: Boolean
)