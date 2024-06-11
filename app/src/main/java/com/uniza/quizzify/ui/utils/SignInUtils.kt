package com.uniza.quizzify.ui.utils

import androidx.navigation.NavController
import com.uniza.quizzify.ui.screens.viewmodel.SignInViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserProgressViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel

object SignInUtils {
    suspend fun performSignIn(
        username: String,
        password: String,
        userViewModel: UserViewModel,
        signInViewModel: SignInViewModel,
        navController: NavController,
        themeViewModel: ThemeViewModel,
        userProgressViewModel : UserProgressViewModel
    ) {
        if (username.isNotEmpty() && password.isNotEmpty()) {
            userViewModel.authenticateUser(username = username, password = password) { authSuccess ->
                if (authSuccess) {
                    userViewModel.user.value?.let { userProgressViewModel.initializeUserProgress(userId = it.userId) }
                    navController.navigate("mainMenu")
                    userViewModel.user.value?.let { themeViewModel.setDarkTheme(it.darkMode) }
                } else {
                    signInViewModel.setErrorMessage("Incorrect username or password")
                    signInViewModel.setShowErrorText(true)
                }
            }
        } else {
            signInViewModel.setErrorMessage("Please fill out all fields")
            signInViewModel.setShowErrorText(true)
        }

    }
}


