package com.uniza.quizzify.ui.navigation

import androidx.compose.runtime.Composable
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

@Composable
fun NavigationGraph(startDestination: String = "initial") {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("initial") { InitialScreen(navController) }
        composable("signIn") { SignInScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("mainMenu") { MainMenuScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("leaderboard") { LeaderboardScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("changeUsername") { ChangeUsernameScreen(navController) }
        composable("changePassword") { ChangePasswordScreen(navController) }
        composable("categories") { CategoryScreen(navController) }
        composable("question"/*TODO*/) { QuestionScreen(navController/*TODO*/) }
    }
}
