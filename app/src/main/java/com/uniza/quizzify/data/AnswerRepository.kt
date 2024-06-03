package com.uniza.quizzify.data

import androidx.lifecycle.LiveData

class AnswerRepository(private val answerDao: AnswerDao) {
    fun getAnswersByQuestion(questionId: Int): LiveData<List<Answer>> = answerDao.getAnswersByQuestion(questionId)
}
