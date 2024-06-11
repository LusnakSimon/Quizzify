package com.uniza.quizzify.ui.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uniza.quizzify.data.Answer
import com.uniza.quizzify.data.AnswerRepository
import com.uniza.quizzify.data.Question
import com.uniza.quizzify.data.QuestionRepository

class QuestionViewModel(
    private val questionRepository: QuestionRepository,
    private val answerRepository: AnswerRepository
    ) : ViewModel() {
    fun getQuestionsByCategory(categoryId: Int): LiveData<List<Question>> = questionRepository.getQuestionsByCategory(categoryId)

    fun getAnswersForQuestion(questionId : Int) : LiveData<List<Answer>> = answerRepository.getAnswersByQuestion(questionId)
}