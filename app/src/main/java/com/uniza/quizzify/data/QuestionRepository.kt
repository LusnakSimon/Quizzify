package com.uniza.quizzify.data

import androidx.lifecycle.LiveData

class QuestionRepository(private val questionDao: QuestionDao) {
    fun getQuestionsByCategory(categoryId: Int): LiveData<List<Question>> = questionDao.getQuestionsByCategory(categoryId)
}
