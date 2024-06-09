package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    var isDarkTheme : MutableState<Boolean> = mutableStateOf(false)
        private set

    fun setDarkTheme(darkTheme : Boolean) {
        isDarkTheme.value = darkTheme
    }
}