package com.uniza.quizzify.ui.screens.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ThemeViewModel(isSystemDarkTheme : Boolean) : ViewModel() {
    var isDarkTheme : MutableState<Boolean> = mutableStateOf(isSystemDarkTheme)
        private set

    fun setDarkTheme(darkTheme : Boolean) {
        isDarkTheme.value = darkTheme
    }
}