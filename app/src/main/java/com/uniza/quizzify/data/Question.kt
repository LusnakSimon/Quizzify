package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "questions",
    indices = [Index(value = ["categoryId"])],
    foreignKeys = [
        ForeignKey(entity = Category::class, parentColumns = ["categoryId"], childColumns = ["categoryId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class Question(
    @PrimaryKey(autoGenerate = true) val questionId: Int = 0,
    val categoryId: Int,
    val questionText: String,
    val imageUrl: String?
)
