package com.uniza.quizzify.data

import androidx.lifecycle.LiveData

class CategoryRepository(private val categoryDao: CategoryDao) {
    fun getAllCategories(): LiveData<List<Category>> = categoryDao.getAllCategories()

}
