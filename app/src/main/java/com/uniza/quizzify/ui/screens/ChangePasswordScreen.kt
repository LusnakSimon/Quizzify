package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.ChangePasswordViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.ChangePasswordUtils
import com.uniza.quizzify.ui.utils.ErrorMessage
import kotlinx.coroutines.launch

@Composable
fun ChangePasswordScreen(
    navController: NavController,
    changePasswordViewModel: ChangePasswordViewModel,
    userViewModel: UserViewModel
) {

    val coroutineScope = rememberCoroutineScope()

    val showErrorText by changePasswordViewModel.showErrorText
    val errorMessage by changePasswordViewModel.errorMessage

    val user by userViewModel.user
    val password by changePasswordViewModel.password
    val newPassword by changePasswordViewModel.newPassword
    val confirmNewPassword by changePasswordViewModel.confirmNewPassword

    BackHandler {
        navController.navigate("profile")
    }

    ScrollableColumn {

        CustomTopBar(
            navController = navController,
            navigateTo = "profile",
            title = stringResource(id = R.string.ChangePassword),
            titleSize = 30.sp
        )

        if (showErrorText) {
            ErrorMessage(text = errorMessage)
        }

        PasswordTextField(
            label = stringResource(id = R.string.Password),
            password = password,
            action = ImeAction.Next,
            onPasswordChange = {changePasswordViewModel.setPassword(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.NewPassword),
            password = newPassword,
            action = ImeAction.Next,
            onPasswordChange = {changePasswordViewModel.setNewPassword(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.ConfirmNewPassword),
            password = confirmNewPassword,
            action = ImeAction.Done,
            onPasswordChange = {changePasswordViewModel.setConfirmNewPassword(it)}
        )

        BlueButton(
            text = stringResource(id = R.string.Confirm),
            onClick = {
                coroutineScope.launch {
                    user?.let {
                        ChangePasswordUtils.changePassword(
                            userId= it.userId,
                            username= it.username,
                            password= password,
                            newPassword= newPassword,
                            confirmNewPassword = confirmNewPassword,
                            changePasswordViewModel = changePasswordViewModel,
                            userViewModel= userViewModel,
                            navController = navController
                        )
                    }
                }
            }
        )

    }
}
