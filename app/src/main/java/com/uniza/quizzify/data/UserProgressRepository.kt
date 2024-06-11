package com.uniza.quizzify.data

class UserProgressRepository(private val userProgressDao: UserProgressDao) {
    suspend fun insertUserProgress(userProgress: UserProgress): Long = userProgressDao.insertUserProgress(userProgress)

    suspend fun getUserProgress(userId: Int, categoryId: Int): UserProgress? = userProgressDao.getUserProgress(userId, categoryId)

    suspend fun incrementUserProgress(userId: Int, categoryId: Int) {
        userProgressDao.incrementUserProgress(userId, categoryId)
    }

    suspend fun resetUserProgress(userId: Int, categoryId: Int) {
        userProgressDao.resetUserProgress(userId, categoryId)
    }

    suspend fun getUserProgressByUserId(userId: Int): List<UserProgress>? = userProgressDao.getUserProgressById(userId)

}
