package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.RegisterViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ErrorMessage
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.RegistrationUtils
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavController, registerViewModel: RegisterViewModel, userViewModel: UserViewModel) {

    val coroutineScope = rememberCoroutineScope()

    val showErrorText by registerViewModel.showErrorText
    val errorMessage by registerViewModel.errorMessage
    val username by registerViewModel.username
    val password by registerViewModel.password
    val confirmPassword by registerViewModel.confirmPassword

    BackHandler {
        navController.navigate("initial")
    }


    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "initial", title = stringResource(
            id = R.string.Register
        ))

        AppLogo()

        if (showErrorText) {
            ErrorMessage(text = errorMessage)
        }

        UsernameTextField(
            label = stringResource(id = R.string.Username),
            username = username,
            onUsernameChange = {registerViewModel.setUsername(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.Password),
            password = password,
            action = ImeAction.Next,
            onPasswordChange = {registerViewModel.setPassword(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.ConfirmPassword),
            password = confirmPassword,
            action = ImeAction.Done,
            onPasswordChange = {registerViewModel.setConfirmPassword(it)}
        )

        BlueButton(
            text = stringResource(id = R.string.Register),
            onClick = {
                coroutineScope.launch {
                    RegistrationUtils.performRegistration(
                        username = username,
                        password = password,
                        confirmPassword = confirmPassword,
                        userViewModel = userViewModel,
                        registerViewModel = registerViewModel,
                        navController = navController
                    )
                }
            }
        )
    }
}
