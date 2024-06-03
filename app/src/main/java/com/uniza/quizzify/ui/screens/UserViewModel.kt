package com.uniza.quizzify.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.uniza.quizzify.data.User
import com.uniza.quizzify.data.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun authenticateUser(username: String, password: String): LiveData<User?> = liveData {
        emit(userRepository.authenticateUser(username, password))
    }
}
