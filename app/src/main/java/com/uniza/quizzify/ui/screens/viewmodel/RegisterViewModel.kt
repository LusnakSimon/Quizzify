package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var username: MutableState<String> = mutableStateOf("")
        private set

    var password: MutableState<String> = mutableStateOf("")
        private set

    var confirmPassword: MutableState<String> = mutableStateOf("")
        private set

    fun setUsername(value: String) {
        username.value = value
    }

    fun setPassword(value: String) {
        password.value = value
    }

    fun setConfirmPassword(value : String) {
        confirmPassword.value = value
    }
}