package com.uniza.quizzify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey val categoryId: Int,
    val categoryName: String,
    val categoryImage: String?,
    val description: String
)