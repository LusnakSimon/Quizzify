package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainMenuViewModel : ViewModel() {
    var showDialog: MutableState<Boolean> = mutableStateOf(false)
        private set

    fun toggleShowDialog() {
        showDialog.value = !showDialog.value
    }
}