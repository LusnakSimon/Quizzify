package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey val questionId: Int,
    val categoryId: Int,
    val questionText: String,
    val image: String?
)