package com.uniza.quizzify.ui.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uniza.quizzify.data.User
import com.uniza.quizzify.data.UserRepository

class LeaderboardViewModel(userRepository: UserRepository) : ViewModel() {
    val topUsers: LiveData<List<User>> = userRepository.getTopUsers()
}