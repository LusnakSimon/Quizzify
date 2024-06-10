package com.uniza.quizzify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uniza.quizzify.data.AppDatabase
import com.uniza.quizzify.data.CategoryRepository
import com.uniza.quizzify.data.UserRepository
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
import com.uniza.quizzify.ui.screens.UserDetailsScreen
import com.uniza.quizzify.ui.screens.viewmodel.CategoryViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ChangePasswordViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ChangeUsernameViewModel
import com.uniza.quizzify.ui.screens.viewmodel.LeaderboardViewModel
import com.uniza.quizzify.ui.screens.viewmodel.MainMenuViewModel
import com.uniza.quizzify.ui.screens.viewmodel.QuestionViewModel
import com.uniza.quizzify.ui.screens.viewmodel.RegisterViewModel
import com.uniza.quizzify.ui.screens.viewmodel.SignInViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.ViewModelFactory

@Composable
fun NavigationGraph(themeViewModel: ThemeViewModel, startDestination: String = "initial") {

    val navController = rememberNavController()

    val database = AppDatabase.getDatabase(context = LocalContext.current)

    val userRepository = UserRepository(database.userDao())
    val categoryRepository = CategoryRepository(database.categoryDao())

    val userViewModelFactory = ViewModelFactory { UserViewModel(userRepository) }
    val userViewModel: UserViewModel = viewModel(factory = userViewModelFactory)

    NavHost(navController = navController, startDestination = startDestination) {

        composable("initial") { InitialScreen(navController, themeViewModel) }

        composable("signIn") {
            val signInViewModelFactory = ViewModelFactory { SignInViewModel() }
            val signInViewModel: SignInViewModel = viewModel(factory = signInViewModelFactory)
            SignInScreen(navController, signInViewModel, userViewModel, themeViewModel)
        }

        composable("register") {
            val registerViewModelFactory = ViewModelFactory { RegisterViewModel() }
            val registerViewModel : RegisterViewModel = viewModel(factory = registerViewModelFactory)
            RegisterScreen(navController, registerViewModel, userViewModel, themeViewModel)
        }

        composable("mainMenu") {
            val mainMenuModelFactory = ViewModelFactory { MainMenuViewModel() }
            val mainMenuViewModel : MainMenuViewModel = viewModel(factory = mainMenuModelFactory)
            MainMenuScreen(navController, mainMenuViewModel, userViewModel, themeViewModel)
        }

        composable("settings") {
            SettingsScreen(navController, themeViewModel, userViewModel)
        }

        composable("leaderboard") {
            val leaderboardViewModelFactory = ViewModelFactory { LeaderboardViewModel(userRepository) }
            val leaderboardViewModel : LeaderboardViewModel = viewModel(factory = leaderboardViewModelFactory)
            LeaderboardScreen(navController, leaderboardViewModel, userViewModel)
        }

        composable("profile") { ProfileScreen(navController, userViewModel) }

        composable("changeUsername") {
            val changeUsernameViewModelFactory = ViewModelFactory { ChangeUsernameViewModel()}
            val changeUsernameViewModel : ChangeUsernameViewModel = viewModel(factory = changeUsernameViewModelFactory)
            ChangeUsernameScreen(navController, changeUsernameViewModel, userViewModel)
        }

        composable("changePassword") {
            val changePasswordViewModelFactory = ViewModelFactory { ChangePasswordViewModel() }
            val changePasswordViewModel : ChangePasswordViewModel = viewModel(factory = changePasswordViewModelFactory)
            ChangePasswordScreen(navController, changePasswordViewModel, userViewModel)
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

        composable("details") {
            UserDetailsScreen(navController = navController, userViewModel = userViewModel)
        }
    }
}
