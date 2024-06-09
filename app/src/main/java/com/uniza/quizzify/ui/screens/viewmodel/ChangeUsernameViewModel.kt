package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChangeUsernameViewModel : ViewModel() {

    var errorMessage : MutableState<String> = mutableStateOf("")
        private set
    var showErrorText : MutableState<Boolean> = mutableStateOf(false)
        private set
    var newUsername: MutableState<String> = mutableStateOf("")
        private set

    var password: MutableState<String> = mutableStateOf("")
        private set

    fun setNewUsername(value: String) {
        newUsername.value = value
    }

    fun setPassword(value: String) {
        password.value = value
    }

    fun setShowErrorText(show : Boolean) {
        showErrorText.value = show
    }

    fun setErrorMessage(message : String) {
        errorMessage.value = message
    }
}