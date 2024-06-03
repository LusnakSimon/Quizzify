package com.uniza.quizzify.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User): Long = userDao.insertUser(user)

    suspend fun authenticateUser(username: String, password: String): User? = userDao.authenticateUser(username, password)

    fun getTopUsers(): LiveData<List<User>> = userDao.getTopUsers()

    suspend fun updateUsername(userId: Int, newUsername: String) = userDao.updateUsername(userId, newUsername)

    suspend fun updatePassword(userId: Int, newPassword: String) = userDao.updatePassword(userId, newPassword)

    suspend fun updateProfilePicture(userId: Int, profilePicture: String) = userDao.updateProfilePicture(userId, profilePicture)

    suspend fun updateUserSettings(userId: Int, darkMode: Boolean, notifications: Boolean, sound: Boolean) {
        userDao.updateUserSettings(userId, darkMode, notifications, sound)
    }

    suspend fun updateRating(userId: Int, increment: Int) = userDao.updateRating(userId, increment)
}
