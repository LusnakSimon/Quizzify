package com.uniza.quizzify.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserProgressDao {
    @Query("SELECT COUNT(*) FROM user_progress WHERE userId = :userId AND isAnswered = 1")
    suspend fun getNumberOfAnsweredQuestionsForUser(userId: Int): Int

    @Query("SELECT COUNT(*) FROM user_progress WHERE userId = :userId AND questionId IN (SELECT questionId FROM questions WHERE categoryId = :categoryId) AND isAnswered = 1")
    suspend fun getNumberOfAnsweredQuestionsInCategoryForUser(userId: Int, categoryId: Int): Int


    @Query("UPDATE user_progress SET isAnswered = :isAnswered WHERE userId = :userId AND questionId = :questionId")
    suspend fun updateUserProgress(userId: Int, questionId: Int, isAnswered: Boolean)

    @Query("UPDATE user_progress SET isAnswered = 0 WHERE userId = :userId AND questionId IN (SELECT questionId FROM questions WHERE categoryId = :categoryId)")
    suspend fun resetUserProgressInCategory(userId: Int, categoryId: Int)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgress(userProgress: UserProgress)

    @Query("SELECT COUNT(*) FROM user_progress WHERE userId = :userId AND questionId IN (SELECT questionId FROM questions WHERE categoryId = :categoryId)")
    suspend fun getNumberOfEntriesForUserInCategory(userId: Int, categoryId: Int): Int


    @Query("SELECT * FROM user_progress WHERE userId = :userId")
    suspend fun getUserProgressById(userId: Int): List<UserProgress>?

    @Query("SELECT * FROM user_progress WHERE userId = :userId AND questionId = :questionId")
    suspend fun getUserProgressByUserQuestionID(userId: Int, questionId: Int): UserProgress?
}
