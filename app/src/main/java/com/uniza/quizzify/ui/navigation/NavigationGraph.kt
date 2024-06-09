package com.uniza.quizzify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uniza.quizzify.ui.screens.CategoryScreen
import com.uniza.quizzify.ui.screens.ChangePasswordScreen
import com.uniza.quizzify.ui.screens.ChangeUsernameScreen
import com.uniza.quizzify.ui.screens.InitialScreen
import com.uniza.quizzify.ui.screens.LeaderboardScreen
import com.uniza.quizzify.ui.screens.MainMenuScreen
import com.uniza.quizzify.ui.screens.ProfileScreen
import com.uniza.quizzify.ui.screens.QuestionScreen
import com.uniza.quizzify.ui.screens.RegisterScreen
import com.uniza.quizzify.ui.screens.SettingsScreen
import com.uniza.quizzify.ui.screens.SignInScreen
import com.uniza.quizzify.ui.screens.viewmodel.CategoryViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ChangePasswordViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ChangeUsernameViewModel
import com.uniza.quizzify.ui.screens.viewmodel.LeaderboardViewModel
import com.uniza.quizzify.ui.screens.viewmodel.QuestionViewModel
import com.uniza.quizzify.ui.screens.viewmodel.RegisterViewModel
import com.uniza.quizzify.ui.screens.viewmodel.SettingsViewModel
import com.uniza.quizzify.ui.screens.viewmodel.SignInViewModel
import com.uniza.quizzify.ui.utils.ViewModelFactory

@Composable
fun NavigationGraph(startDestination: String = "initial") {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        composable("initial") { InitialScreen(navController) }

        composable("signIn") {
            val signInViewModelFactory = ViewModelFactory { SignInViewModel() }
            val signInViewModel: SignInViewModel = viewModel(factory = signInViewModelFactory)
            SignInScreen(navController, signInViewModel)
        }

        composable("register") {
            val registerViewModelFactory = ViewModelFactory { RegisterViewModel() }
            val registerViewModel : RegisterViewModel = viewModel(factory = registerViewModelFactory)
            RegisterScreen(navController, registerViewModel)
        }

        composable("mainMenu") { MainMenuScreen(navController) }

        composable("settings") {
            val settingsViewModelFactory = ViewModelFactory { SettingsViewModel() }
            val settingsViewModel: SettingsViewModel = viewModel(factory = settingsViewModelFactory)
            SettingsScreen(navController, settingsViewModel)
        }

        composable("leaderboard") {
            val leaderboardViewModelFactory = ViewModelFactory { LeaderboardViewModel() }
            val leaderboardViewModel : LeaderboardViewModel = viewModel(factory = leaderboardViewModelFactory)
            LeaderboardScreen(navController, leaderboardViewModel)
        }

        composable("profile") { ProfileScreen(navController) }

        composable("changeUsername") {
            val changeUsernameViewModelFactory = ViewModelFactory { ChangeUsernameViewModel()}
            val changeUsernameViewModel : ChangeUsernameViewModel = viewModel(factory = changeUsernameViewModelFactory)
            ChangeUsernameScreen(navController, changeUsernameViewModel)
        }

        composable("changePassword") {
            val changePasswordViewModelFactory = ViewModelFactory { ChangePasswordViewModel() }
            val changePasswordViewModel : ChangePasswordViewModel = viewModel(factory = changePasswordViewModelFactory)
            ChangePasswordScreen(navController, changePasswordViewModel)
        }

        composable("categories") {
            val categoryViewModelFactory = ViewModelFactory { CategoryViewModel() }
            val categoryViewModel : CategoryViewModel = viewModel(factory = categoryViewModelFactory)
            CategoryScreen(navController, categoryViewModel)
        }

        composable("question"/*TODO*/) {
            val questionViewModelFactory = ViewModelFactory { QuestionViewModel() }
            val questionViewModel : QuestionViewModel = viewModel(factory = questionViewModelFactory)
            QuestionScreen(navController, questionViewModel)
        }
    }
}
