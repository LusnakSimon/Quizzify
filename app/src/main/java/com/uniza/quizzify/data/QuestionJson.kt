package com.uniza.quizzify.data

import kotlinx.serialization.Serializable

@Serializable
data class QuestionJson(
    val questionId: Int,
    val categoryId: Int,
    val questionText: String,
    val imageId: Int
)