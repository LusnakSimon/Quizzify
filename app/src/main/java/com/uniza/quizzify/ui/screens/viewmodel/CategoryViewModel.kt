package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uniza.quizzify.data.Category
import com.uniza.quizzify.data.CategoryRepository
import com.uniza.quizzify.data.QuestionRepository


class CategoryViewModel(categoryRepository: CategoryRepository, private val questionRepository: QuestionRepository) : ViewModel() {
    val categories: LiveData<List<Category>> = categoryRepository.getAllCategories()

    var showDialog : MutableState<Boolean> = mutableStateOf(false)
        private set

    var selectedCategory : MutableState<Category?> = mutableStateOf(null)
        private set
    fun showResetDialog(category: Category) {
        selectedCategory.value = category
        showDialog.value = true
    }

    fun dismissDialog() {
        showDialog.value = false
        selectedCategory.value = null
    }
    fun getQuestionCountByCategory(categoryId: Int): LiveData<Int> = questionRepository.getQuestionCountByCategory(categoryId)

}