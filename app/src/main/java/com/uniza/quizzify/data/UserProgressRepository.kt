package com.uniza.quizzify.data

class UserProgressRepository(private val userProgressDao: UserProgressDao) {

    suspend fun getNumberOfAnsweredQuestionsForUser(userId: Int): Int {
        return userProgressDao.getNumberOfAnsweredQuestionsForUser(userId)
    }

    suspend fun getNumberOfAnsweredQuestionsInCategoryForUser(userId: Int, categoryId: Int): Int {
        return userProgressDao.getNumberOfAnsweredQuestionsInCategoryForUser(userId, categoryId)
    }

    suspend fun updateUserProgress(userId: Int, questionId: Int, isAnswered: Boolean) {
        userProgressDao.updateUserProgress(userId, questionId, isAnswered)
    }

    suspend fun resetUserProgressInCategory(userId: Int, categoryId: Int) {
        userProgressDao.resetUserProgressInCategory(userId, categoryId)
    }

    suspend fun insertUserProgress(userProgress: UserProgress) {
        userProgressDao.insertUserProgress(userProgress)
    }

    suspend fun getNumberOfEntriesForUserInCategory(userId: Int, categoryId: Int): Int {
        return userProgressDao.getNumberOfEntriesForUserInCategory(userId, categoryId)
    }

    suspend fun getUserProgressByUserId(userId: Int): List<UserProgress>? = userProgressDao.getUserProgressById(userId)

    suspend fun getUserProgressByUserQuestionID(userId: Int, questionId : Int): UserProgress? = userProgressDao.getUserProgressByUserQuestionID(userId, questionId)
}

