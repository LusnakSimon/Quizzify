package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "questions",
    foreignKeys = [ForeignKey(entity = Category::class, parentColumns = ["categoryId"], childColumns = ["categoryId"])]
)
data class Question(
    @PrimaryKey(autoGenerate = true) val questionId: Int = 0,
    val categoryId: Int,
    val questionText: String,
    val imageUrl: String? = null
)