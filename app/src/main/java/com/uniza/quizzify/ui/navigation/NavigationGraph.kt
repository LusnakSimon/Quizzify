package com.uniza.quizzify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uniza.quizzify.data.AppDatabase
import com.uniza.quizzify.data.CategoryRepository
import com.uniza.quizzify.data.QuestionRepository
import com.uniza.quizzify.data.UserProgressRepository
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
import com.uniza.quizzify.ui.screens.viewmodel.UserProgressViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.ViewModelFactory

@Composable
fun NavigationGraph(themeViewModel: ThemeViewModel, startDestination: String = "initial") {

    val navController = rememberNavController()

    val database = AppDatabase.getDatabase(context = LocalContext.current)

    val userRepository = UserRepository(database.userDao())
    val categoryRepository = CategoryRepository(database.categoryDao())
    val userProgressRepository = UserProgressRepository(database.userProgressDao())
    val questionRepository = QuestionRepository(database.questionDao())

    val userProgressViewModelFactory = ViewModelFactory { UserProgressViewModel(userProgressRepository, categoryRepository) }
    val userProgressViewModel: UserProgressViewModel = viewModel(factory = userProgressViewModelFactory)

    val userViewModelFactory = ViewModelFactory { UserViewModel(userRepository) }
    val userViewModel: UserViewModel = viewModel(factory = userViewModelFactory)

    NavHost(navController = navController, startDestination = startDestination) {

        composable("initial") { InitialScreen(navController, themeViewModel) }

        composable("signIn") {
            val signInViewModelFactory = ViewModelFactory { SignInViewModel() }
            val signInViewModel: SignInViewModel = viewModel(factory = signInViewModelFactory)
            SignInScreen(navController, signInViewModel, userViewModel, themeViewModel, userProgressViewModel)
        }

        composable("register") {
            val registerViewModelFactory = ViewModelFactory { RegisterViewModel() }
            val registerViewModel : RegisterViewModel = viewModel(factory = registerViewModelFactory)
            RegisterScreen(navController, registerViewModel, userViewModel, themeViewModel, userProgressViewModel)
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
            val categoryViewModelFactory = ViewModelFactory { CategoryViewModel(categoryRepository, questionRepository) }
            val categoryViewModel : CategoryViewModel = viewModel(factory = categoryViewModelFactory)
            CategoryScreen(navController, categoryViewModel, userProgressViewModel, userViewModel)
        }

        composable("question/{categoryId}") { backStackEntry ->
            val questionViewModelFactory = ViewModelFactory { QuestionViewModel(questionRepository) }
            val questionViewModel : QuestionViewModel = viewModel(factory = questionViewModelFactory)
            val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull()
            if (categoryId != null) {
                QuestionScreen(navController, categoryId, questionViewModel, userProgressViewModel, userViewModel)
            }
        }

        composable("details") {
            UserDetailsScreen(navController = navController, userViewModel = userViewModel)
        }
    }
}
