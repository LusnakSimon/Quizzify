package com.uniza.quizzify.data

import kotlinx.serialization.Serializable

@Serializable
data class AnswerJson(
    val answerId: Int,
    val questionId: Int,
    val answerText: String,
    val isCorrect: Boolean
)