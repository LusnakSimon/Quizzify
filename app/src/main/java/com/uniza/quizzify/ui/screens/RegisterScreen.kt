package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(navController: NavController, registerViewModel: RegisterViewModel) {

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
        
        UsernameTextField(
            label = stringResource(id = R.string.Username),
            username = username,
            onUsernameChange = {registerViewModel.setUsername(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.Password),
            password = password,
            onPasswordChange = {registerViewModel.setPassword(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.ChangePassword),
            password = confirmPassword,
            onPasswordChange = {registerViewModel.setConfirmPassword(it)}
        )

        BlueButton(text = stringResource(id = R.string.Register), onClick = {navController.navigate("mainMenu")})

    }
}
