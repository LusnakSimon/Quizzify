package com.uniza.quizzify.ui.utils

import androidx.navigation.NavController
import com.uniza.quizzify.ui.screens.viewmodel.ChangePasswordViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel

object ChangePasswordUtils {
    suspend fun changePassword(
        userId : Int,
        username : String,
        password : String,
        newPassword : String,
        confirmNewPassword : String,
        changePasswordViewModel: ChangePasswordViewModel,
        userViewModel: UserViewModel,
        navController: NavController
    ) {
        val errorMessage = when {
            newPassword.isEmpty() || password.isEmpty() || confirmNewPassword.isEmpty()  -> "Please fill out all fields."
            newPassword.length < 3 -> "New password is too short."
            password != (userViewModel.user.value?.password ?: String) -> "Incorrect password."
            newPassword != confirmNewPassword -> "Passwords must match."
            else -> {
                userViewModel.updatePassword(userId, newPassword)
                userViewModel.authenticateUser(username, newPassword) {
                        authSuccess ->
                    if (authSuccess) {
                        navController.navigate("profile")
                    } else {
                        changePasswordViewModel.setErrorMessage("Error! Unable to change password.")
                        changePasswordViewModel.setShowErrorText(true)
                    }
                }
                return
            }
        }
        changePasswordViewModel.setErrorMessage(errorMessage)
        changePasswordViewModel.setShowErrorText(true)
    }
}

