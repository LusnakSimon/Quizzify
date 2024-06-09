package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.uniza.quizzify.data.User
import com.uniza.quizzify.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val userRepository : UserRepository): ViewModel() {

    var user: MutableState<User?> = mutableStateOf(null)
        private set

    var isDarkTheme = user.value?.darkMode
        private set

    var notifications = user.value?.notifications
        private set

    fun authenticateUser(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val authenticatedUser = userRepository.authenticateUser(username, password)
            withContext(Dispatchers.Main) {
                user.value = authenticatedUser
                onResult(authenticatedUser != null)
            }
        }
    }

    fun registerUser(username: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = userRepository.registerUser(User(username = username, password = password))
            withContext(Dispatchers.Main) {
                onResult(result > 0)
            }
        }
    }

    suspend fun isUsernameTaken(username: String): Boolean {
        return userRepository.getUserByUsername(username) != null
    }

    suspend fun updateUsername(userId: Int, newUsername: String) {
        userRepository.updateUsername(userId, newUsername)
    }

    suspend fun updatePassword(userId: Int, newPassword: String) {
        userRepository.updatePassword(userId, newPassword)
    }

    suspend fun updateUserSettings(darkTheme : Boolean, notifications : Boolean) {
        user.value?.let { userRepository.updateUserSettings(it.userId, darkTheme, notifications) }
    }


    fun signOut() {
        user.value = null
    }
}