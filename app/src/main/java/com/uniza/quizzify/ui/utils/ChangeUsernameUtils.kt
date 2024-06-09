package com.uniza.quizzify.ui.utils

import androidx.navigation.NavController
import com.uniza.quizzify.ui.screens.viewmodel.ChangeUsernameViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel

object ChangeUsernameUtils {
    suspend fun changeUsername(
        userId : Int,
        username : String,
        password : String,
        changeUsernameViewModel: ChangeUsernameViewModel,
        userViewModel: UserViewModel,
        navController: NavController
    ) {
        if(password == (userViewModel.user.value?.password ?: String)) {
            if(!userViewModel.isUsernameTaken(username)) {
                userViewModel.updateUsername(userId, username)
                userViewModel.authenticateUser(username, password) {
                        authSuccess ->
                    if (authSuccess) {
                        navController.navigate("profile")
                    } else {
                        changeUsernameViewModel.setErrorMessage("Error! Unable to change username.")
                        changeUsernameViewModel.setShowErrorText(true)
                    }
                }
            } else {
                changeUsernameViewModel.setErrorMessage("Username is already taken")
                changeUsernameViewModel.setShowErrorText(true)
            }
        } else {
            changeUsernameViewModel.setErrorMessage("Incorrect password")
            changeUsernameViewModel.setShowErrorText(true)
        }

    }
}