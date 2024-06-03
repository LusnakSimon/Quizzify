package com.uniza.quizzify.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProgress(userProgress: UserProgress): Long

    @Query("SELECT * FROM user_progress WHERE userId = :userId AND categoryId = :categoryId LIMIT 1")
    suspend fun getUserProgress(userId: Int, categoryId: Int): UserProgress?

    @Query("UPDATE user_progress SET progress = :progress WHERE userId = :userId AND categoryId = :categoryId")
    suspend fun updateUserProgress(userId: Int, categoryId: Int, progress: Float)

    @Query("DELETE FROM user_progress WHERE userId = :userId AND categoryId = :categoryId")
    suspend fun clearUserProgress(userId: Int, categoryId: Int)
}