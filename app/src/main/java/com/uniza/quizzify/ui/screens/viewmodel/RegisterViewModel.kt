package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    var errorMessage : MutableState<String> = mutableStateOf("")

    var showErrorText : MutableState<Boolean> = mutableStateOf(false)
        private set
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

    fun setShowErrorText(show : Boolean) {
        showErrorText.value = show
    }

    fun setErrorMessage(message : String) {
        errorMessage.value = message
    }
}