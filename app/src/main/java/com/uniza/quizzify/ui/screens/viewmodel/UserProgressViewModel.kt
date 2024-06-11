package com.uniza.quizzify.ui.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uniza.quizzify.data.Category
import com.uniza.quizzify.data.CategoryRepository
import com.uniza.quizzify.data.UserProgress
import com.uniza.quizzify.data.UserProgressRepository
import kotlinx.coroutines.launch

class UserProgressViewModel(
    private val userProgressRepository: UserProgressRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    val categories: LiveData<List<Category>> = categoryRepository.getAllCategories()

    private val _userProgressList = MutableLiveData<List<UserProgress>?>()
    val userProgressList: MutableLiveData<List<UserProgress>?> = _userProgressList
    fun fetchUserProgress(userId: Int) {
        viewModelScope.launch {
            val progressList = userProgressRepository.getUserProgressByUserId(userId)
            _userProgressList.value = progressList
        }
    }

    fun getUserProgressForCategory(categoryId: Int): UserProgress? {
        return _userProgressList.value?.find { it.categoryId == categoryId }
    }
    fun incrementProgress(userId: Int, categoryId: Int) {
        viewModelScope.launch {
            userProgressRepository.incrementUserProgress(userId, categoryId)
        }
    }

    fun initializeUserProgress(userId: Int) {
        viewModelScope.launch {
            val categories = categoryRepository.getAllCategoriesSync()
            categories.forEach { category ->
                val existingProgress = userProgressRepository.getUserProgress(userId, category.categoryId)
                if (existingProgress == null) {
                    val userProgress = UserProgress(userId = userId, categoryId = category.categoryId, progress = 1)
                    userProgressRepository.insertUserProgress(userProgress)
                }
            }
        }
    }

    fun resetProgress(userId: Int, categoryId: Int) {
        viewModelScope.launch {
            userProgressRepository.resetUserProgress(userId, categoryId)
        }
    }


}