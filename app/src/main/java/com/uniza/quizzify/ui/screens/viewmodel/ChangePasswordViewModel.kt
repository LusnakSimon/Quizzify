package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChangePasswordViewModel : ViewModel() {

    var errorMessage : MutableState<String> = mutableStateOf("")
        private set
    var showErrorText : MutableState<Boolean> = mutableStateOf(false)
        private set
    var password: MutableState<String> = mutableStateOf("")
        private set

    var newPassword: MutableState<String> = mutableStateOf("")
        private set

    var confirmNewPassword: MutableState<String> = mutableStateOf("")
        private set

    fun setPassword(value: String) {
        password.value = value
    }

    fun setNewPassword(value: String) {
        newPassword.value = value
    }

    fun setConfirmNewPassword(value : String) {
        confirmNewPassword.value = value
    }

    fun setShowErrorText(show : Boolean) {
        showErrorText.value = show
    }

    fun setErrorMessage(message : String) {
        errorMessage.value = message
    }
}