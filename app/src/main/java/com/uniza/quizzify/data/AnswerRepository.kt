package com.uniza.quizzify.data

import androidx.lifecycle.LiveData

class AnswerRepository(private val answerDao: AnswerDao) {
    fun getAnswersByQuestion(questionId: Int): LiveData<List<Answer>> = answerDao.getAnswersByQuestion(questionId)
    suspend fun getAllAnswersSync(): List<Answer> = answerDao.getAllAnswersSync()
    suspend fun insertAnswer(answer: Answer) {
        answerDao.insertAnswer(answer)
    }
}
