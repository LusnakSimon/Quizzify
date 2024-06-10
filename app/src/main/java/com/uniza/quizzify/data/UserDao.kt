package com.uniza.quizzify.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1")
    suspend fun authenticateUser(username: String, password: String): User?

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM users ORDER BY rating DESC LIMIT 100")
    fun getTopUsers(): LiveData<List<User>>

    @Query("UPDATE users SET username = :newUsername WHERE userId = :userId")
    suspend fun updateUsername(userId: Int, newUsername: String)

    @Query("UPDATE users SET password = :newPassword WHERE userId = :userId")
    suspend fun updatePassword(userId: Int, newPassword: String)

    @Query("UPDATE users SET darkMode = :darkMode WHERE userId = :userId")
    suspend fun updateUserDarkTheme(userId : Int, darkMode : Boolean)

    @Query("UPDATE users SET notifications = :notifications WHERE userId = :userId")
    suspend fun updateUserNotifications(userId : Int, notifications : Boolean)

    @Query("UPDATE users SET rating = rating + :increment WHERE userId = :userId")
    suspend fun updateRating(userId: Int, increment: Int)

}