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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun ChangePasswordScreen(navController: NavController) {

    BackHandler {
        navController.navigate("profile")
    }

    var password by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmNewPassword by remember { mutableStateOf("") }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "profile", title = "Change password", titleSize = 30.sp)

        PasswordTextField(label = "Password", password = password, onPasswordChange = {password = it})

        PasswordTextField(label = "New password", password = newPassword, onPasswordChange = {newPassword = it})

        PasswordTextField(label = "Confirm new password", password = confirmNewPassword, onPasswordChange = {confirmNewPassword = it})

        BlueButton(text = "Confirm", onClick = {/*TODO*/})

    }
}
