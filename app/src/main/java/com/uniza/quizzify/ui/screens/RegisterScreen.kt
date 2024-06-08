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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField

@Composable
fun RegisterScreen(navController: NavController) {

    BackHandler {
        navController.navigate("initial")
    }

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "initial", title = "Register")

        AppLogo()
        
        UsernameTextField(label = "Username", username = username, onUsernameChange = {username = it})

        PasswordTextField(label = "Password", password = password, onPasswordChange = {password = it})

        PasswordTextField(label = "Confirm password", password = confirmPassword, onPasswordChange = {confirmPassword = it})

        BlueButton(text = "Register", onClick = {navController.navigate("mainMenu")})

    }
}
