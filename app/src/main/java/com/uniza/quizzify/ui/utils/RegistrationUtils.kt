package com.uniza.quizzify.ui.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.uniza.quizzify.data.Category
import com.uniza.quizzify.data.UserProgress
import com.uniza.quizzify.ui.screens.viewmodel.RegisterViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserProgressViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel

object RegistrationUtils {
    suspend fun performRegistration(
        username: String,
        password: String,
        confirmPassword: String,
        userViewModel: UserViewModel,
        registerViewModel: RegisterViewModel,
        navController: NavController,
        themeViewModel: ThemeViewModel,
        categories : List<Category>,
        userProgressViewModel: UserProgressViewModel
    ) {
        val errorMessage = when {
            username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> "Please fill out all fields."
            username.length < 3 -> "Username is too short."
            password.length < 3 -> "Password is too short."
            password != confirmPassword -> "Passwords do not match."
            userViewModel.isUsernameTaken(username) -> "Username is already taken."
            else -> {
                userViewModel.registerUser(username = username, password = password, darkMode = themeViewModel.isDarkTheme.value) { registerSuccess ->
                    if (registerSuccess) {
                        userViewModel.authenticateUser(username = username, password = password) { authSuccess ->
                            if (authSuccess) {
                                /*TODO here*/
                                userViewModel.user.value?.let { userProgressViewModel.initializeUserProgress(userId = it.userId) }
                                navController.navigate("mainMenu")
                            } else {
                                registerViewModel.setShowErrorText(true)
                            }
                        }
                    } else {
                        registerViewModel.setShowErrorText(true)
                    }
                }
                return
            }
        }
        registerViewModel.setErrorMessage(errorMessage)
        registerViewModel.setShowErrorText(true)
    }
}
