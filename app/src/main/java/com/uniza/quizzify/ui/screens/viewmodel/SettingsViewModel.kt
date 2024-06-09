package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    var darkTheme: MutableState<Boolean> = mutableStateOf(false)
        private set

    var notifications: MutableState<Boolean> = mutableStateOf(false)
        private set

    fun toggleDarkTheme() {
        darkTheme.value = !darkTheme.value
    }

    fun toggleNotifications() {
        notifications.value = !notifications.value
    }
}