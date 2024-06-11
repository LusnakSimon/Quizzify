package com.uniza.quizzify.ui.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uniza.quizzify.data.Category
import com.uniza.quizzify.data.QuestionRepository
import com.uniza.quizzify.data.UserProgress
import com.uniza.quizzify.data.UserProgressRepository
import kotlinx.coroutines.launch

class UserProgressViewModel(
    private val userProgressRepository: UserProgressRepository,
    private val questionRepository: QuestionRepository
    ) : ViewModel() {

    private val _userProgressList = MutableLiveData<List<UserProgress>?>()
    fun fetchUserProgress(userId: Int) {
        viewModelScope.launch {
            val progressList = userProgressRepository.getUserProgressByUserId(userId)
            _userProgressList.value = progressList
        }
    }

    private val _answeredQuestionsCount = MutableLiveData<Int>()


    private val _answeredQuestionsInCategoryCount = MutableLiveData<Map<Int, Int>>()
    val answeredQuestionsInCategoryCount: LiveData<Map<Int, Int>> get() = _answeredQuestionsInCategoryCount

    private val _totalQuestionsInCategoryCount = MutableLiveData<Map<Int, Int>>()
    val totalQuestionsInCategoryCount: LiveData<Map<Int, Int>> get() = _totalQuestionsInCategoryCount

    fun fetchAllProgressData(userId: Int, categories: List<Category>) {
        viewModelScope.launch {
            val answeredQuestionsCount = userProgressRepository.getNumberOfAnsweredQuestionsForUser(userId)
            _answeredQuestionsCount.postValue(answeredQuestionsCount)

            val answeredQuestionsMap = mutableMapOf<Int, Int>()
            val totalQuestionsMap = mutableMapOf<Int, Int>()

            categories.forEach { category ->
                val answeredCount = userProgressRepository.getNumberOfAnsweredQuestionsInCategoryForUser(userId, category.categoryId)
                answeredQuestionsMap[category.categoryId] = answeredCount

                val totalQuestionsCount = userProgressRepository.getNumberOfEntriesForUserInCategory(userId, category.categoryId)
                totalQuestionsMap[category.categoryId] = totalQuestionsCount
            }

            _answeredQuestionsInCategoryCount.postValue(answeredQuestionsMap)
            _totalQuestionsInCategoryCount.postValue(totalQuestionsMap)
        }
    }

    fun updateUserProgress(userId: Int, questionId: Int, isAnswered: Boolean) {
        viewModelScope.launch {
            userProgressRepository.updateUserProgress(userId, questionId, isAnswered)
        }
    }

    fun resetUserProgressInCategory(userId: Int, categoryId: Int) {
        viewModelScope.launch {
            userProgressRepository.resetUserProgressInCategory(userId, categoryId)
        }
    }

    fun initializeUserProgress(userId: Int) {
        viewModelScope.launch {
            val questions = questionRepository.getAllQuestionsSync()
            questions.forEach { question ->
                val existingProgress = userProgressRepository.getUserProgressByUserQuestionID(userId, question.questionId)
                if (existingProgress == null) {
                    val userProgress =
                        UserProgress(userId = userId, questionId = question.questionId)
                    userProgressRepository.insertUserProgress(userProgress)
                }
            }
        }
    }

}