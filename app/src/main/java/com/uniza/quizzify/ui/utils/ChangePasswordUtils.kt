package com.uniza.quizzify.ui.utils

import androidx.navigation.NavController
import com.uniza.quizzify.ui.screens.viewmodel.ChangePasswordViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ChangeUsernameViewModel
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
        if(password == (userViewModel.user.value?.password ?: String)) {
            if(newPassword == confirmNewPassword) {
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
            } else {
                changePasswordViewModel.setErrorMessage("Passwords do not match.")
                changePasswordViewModel.setShowErrorText(true)
            }
        } else {
            changePasswordViewModel.setErrorMessage("Incorrect password")
            changePasswordViewModel.setShowErrorText(true)
        }

    }
}