package com.uniza.quizzify.ui.utils

import androidx.navigation.NavController
import com.uniza.quizzify.ui.screens.viewmodel.ChangeUsernameViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel

object ChangeUsernameUtils {
    suspend fun changeUsername(
        userId : Int,
        newUsername: String,
        password: String,
        userViewModel: UserViewModel,
        changeUsernameViewModel: ChangeUsernameViewModel,
        navController: NavController
    ) {
        val errorMessage = when {
            newUsername.isEmpty() || password.isEmpty()  -> "Please fill out all fields."
            newUsername.length < 3 -> "Username is too short."
            password != (userViewModel.user.value?.password ?: String) -> "Incorrect password."
            userViewModel.isUsernameTaken(newUsername) -> "Username is already taken."
            else -> {
                userViewModel.updateUsername(userId, newUsername)
                userViewModel.authenticateUser(newUsername, password) {
                        authSuccess ->
                    if (authSuccess) {
                        navController.navigate("profile")
                    } else {
                        changeUsernameViewModel.setErrorMessage("Error! Unable to change username.")
                        changeUsernameViewModel.setShowErrorText(true)
                    }
                }
                return
            }
        }
        changeUsernameViewModel.setErrorMessage(errorMessage)
        changeUsernameViewModel.setShowErrorText(true)
    }
}

