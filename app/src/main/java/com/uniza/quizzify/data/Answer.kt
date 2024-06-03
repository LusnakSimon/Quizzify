package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "answers",
    foreignKeys = [ForeignKey(entity = Question::class, parentColumns = ["questionId"], childColumns = ["questionId"])]
)
data class Answer(
    @PrimaryKey(autoGenerate = true) val answerId: Int = 0,
    val questionId: Int,
    val answerText: String,
    val isCorrect: Boolean
)