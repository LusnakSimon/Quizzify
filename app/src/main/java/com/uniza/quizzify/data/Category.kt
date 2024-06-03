package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Int = 0,
    val categoryName: String,
    val description: String,
    val imageUrl: String
)