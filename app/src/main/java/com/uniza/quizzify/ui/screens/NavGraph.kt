package com.uniza.quizzify.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(startDestination: String = "initial") {
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
        composable("question") { QuestionScreen(navController)}
    }
}
