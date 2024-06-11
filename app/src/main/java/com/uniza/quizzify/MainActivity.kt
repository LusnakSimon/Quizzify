package com.uniza.quizzify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uniza.quizzify.data.AnswerRepository
import com.uniza.quizzify.data.AppDatabase
import com.uniza.quizzify.data.CategoryRepository
import com.uniza.quizzify.data.DatabaseInitializer
import com.uniza.quizzify.data.QuestionRepository
import com.uniza.quizzify.ui.navigation.NavigationGraph
import com.uniza.quizzify.ui.screens.viewmodel.LeaderboardViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel
import com.uniza.quizzify.ui.theme.QuizzifyTheme
import com.uniza.quizzify.ui.utils.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val categoryDao = AppDatabase.getDatabase(this).categoryDao()
        val questionDao = AppDatabase.getDatabase(this).questionDao()
        val answerDao = AppDatabase.getDatabase(this).answerDao()

        val categoryRepository = CategoryRepository(categoryDao)
        val questionRepository = QuestionRepository(questionDao)
        val answerRepository = AnswerRepository(answerDao)

        val databaseInitializer = DatabaseInitializer(this, categoryRepository, questionRepository, answerRepository)

        CoroutineScope(Dispatchers.IO).launch {
            databaseInitializer.initialize()
        }

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
