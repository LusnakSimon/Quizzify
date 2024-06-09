package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.SignInViewModel

@Composable
fun SignInScreen(navController: NavController, signInViewModel: SignInViewModel) {

    val username by signInViewModel.username
    val password by signInViewModel.password

    BackHandler {
        navController.navigate("initial")
    }

    ScrollableColumn {

        CustomTopBar(
            navController = navController,
            navigateTo = "initial",
            title = stringResource(id = R.string.SignIn)
        )

        AppLogo()

        UsernameTextField(
            label = stringResource(id = R.string.Username),
            username = username,
            onUsernameChange = { signInViewModel.setUsername(it) }
        )

        PasswordTextField(
            label = stringResource(id = R.string.Password),
            password = password,
            onPasswordChange = {signInViewModel.setPassword(it)}
        )

        BlueButton(text = stringResource(id = R.string.SignIn), onClick = {navController.navigate("mainMenu")})

    }
}
