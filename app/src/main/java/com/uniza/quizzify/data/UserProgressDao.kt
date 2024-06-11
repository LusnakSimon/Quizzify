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

    @Query("UPDATE user_progress SET progress = progress + 1 WHERE userId = :userId AND categoryId = :categoryId")
    suspend fun incrementUserProgress(userId: Int, categoryId: Int)

    @Query("UPDATE user_progress SET progress = 0 WHERE userId = :userId AND categoryId = :categoryId")
    suspend fun resetUserProgress(userId: Int, categoryId: Int)
    @Query("SELECT * FROM user_progress WHERE userId = :userId")
    suspend fun getUserProgressById(userId: Int): List<UserProgress>?
}