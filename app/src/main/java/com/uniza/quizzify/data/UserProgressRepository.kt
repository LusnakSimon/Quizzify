package com.uniza.quizzify.data

class UserProgressRepository(private val userProgressDao: UserProgressDao) {
    suspend fun insertUserProgress(userProgress: UserProgress): Long = userProgressDao.insertUserProgress(userProgress)

    suspend fun getUserProgress(userId: Int, categoryId: Int): UserProgress? = userProgressDao.getUserProgress(userId, categoryId)

    suspend fun updateUserProgress(userId: Int, categoryId: Int, progress: Float) = userProgressDao.updateUserProgress(userId, categoryId, progress)

    suspend fun clearUserProgress(userId: Int, categoryId: Int) = userProgressDao.clearUserProgress(userId, categoryId)
}
