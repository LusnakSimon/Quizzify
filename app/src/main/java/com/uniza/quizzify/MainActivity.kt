package com.uniza.quizzify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uniza.quizzify.ui.navigation.NavigationGraph
import com.uniza.quizzify.ui.screens.viewmodel.LeaderboardViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel
import com.uniza.quizzify.ui.theme.QuizzifyTheme
import com.uniza.quizzify.ui.utils.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val isSystemDarkTheme = isSystemInDarkTheme()
            val themeViewModelFactory = ViewModelFactory { ThemeViewModel(isSystemDarkTheme) }
            val themeViewModel : ThemeViewModel = viewModel(factory = themeViewModelFactory)
            val isDarkTheme by themeViewModel.isDarkTheme

            QuizzifyTheme(isDarkTheme) {

                NavigationGraph(themeViewModel)

            }
        }
    }
}
