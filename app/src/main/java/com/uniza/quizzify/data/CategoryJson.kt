package com.uniza.quizzify.data

import kotlinx.serialization.Serializable

@Serializable
data class CategoryJson(
    val categoryId: Int,
    val categoryName: String,
    val description: String,
    val imageId: Int
)