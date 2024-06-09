package com.uniza.quizzify.ui.utils

import androidx.navigation.NavController
import com.uniza.quizzify.ui.screens.viewmodel.SignInViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel

object SignInUtils {
    suspend fun performSignIn(
        username: String,
        password: String,
        userViewModel: UserViewModel,
        signInViewModel: SignInViewModel,
        navController: NavController
    ) {
        if (username.isNotEmpty() && password.isNotEmpty()) {
            userViewModel.authenticateUser(username = username, password = password) { authSuccess ->
                if (authSuccess) {
                    navController.navigate("mainMenu")
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


