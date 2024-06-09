package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.ChangeUsernameViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.ChangeUsernameUtils
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ErrorMessage
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField
import kotlinx.coroutines.launch

@Composable
fun ChangeUsernameScreen(
    navController: NavController,
    changeUsernameViewModel: ChangeUsernameViewModel,
    userViewModel: UserViewModel
) {

    val coroutineScope = rememberCoroutineScope()

    val showErrorText by changeUsernameViewModel.showErrorText
    val errorMessage by changeUsernameViewModel.errorMessage

    val user by userViewModel.user
    val newUsername by changeUsernameViewModel.newUsername
    val password by changeUsernameViewModel.password

    BackHandler {
        navController.navigate("profile")
    }

    ScrollableColumn {

        CustomTopBar(
            navController = navController,
            navigateTo = "profile",
            title = stringResource(id = R.string.ChangeUsername),
            titleSize = 30.sp
        )

        if (showErrorText) {
            ErrorMessage(text = errorMessage)
        }

        UsernameTextField(
            label = stringResource(id = R.string.NewUsername),
            username = newUsername,
            onUsernameChange = {changeUsernameViewModel.setNewUsername(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.Password),
            password = password,
            action = ImeAction.Done,
            onPasswordChange = {changeUsernameViewModel.setPassword(it)}
        )

        BlueButton(
            text = stringResource(id = R.string.Confirm),
            onClick = {
                coroutineScope.launch {
                    user?.let {
                        ChangeUsernameUtils.changeUsername(
                            userId = it.userId,
                            newUsername = newUsername,
                            password = password,
                            changeUsernameViewModel = changeUsernameViewModel,
                            userViewModel = userViewModel,
                            navController = navController)
                    }
                }
            }
        )

    }

}
