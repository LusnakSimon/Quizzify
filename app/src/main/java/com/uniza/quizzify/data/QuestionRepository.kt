package com.uniza.quizzify.data

import androidx.lifecycle.LiveData

class QuestionRepository(private val questionDao: QuestionDao) {
    fun getQuestionsByCategory(categoryId: Int): LiveData<List<Question>> = questionDao.getQuestionsByCategory(categoryId)
    suspend fun getAllQuestionsSync(): List<Question> = questionDao.getAllQuestionsSync()
    suspend fun insertQuestion(question: Question) {
        questionDao.insertQuestion(question)
    }

    fun getQuestionCountByCategory(categoryId: Int): LiveData<Int> = questionDao.getQuestionCountByCategory(categoryId)

}
