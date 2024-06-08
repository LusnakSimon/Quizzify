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
import com.uniza.quizzify.ui.utils.UsernameTextField

@Composable
fun ChangeUsernameScreen(navController: NavController) {

    BackHandler {
        navController.navigate("profile")
    }

    var newUsername by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "profile", title = "Change username", titleSize = 30.sp)

        UsernameTextField(label = "New username", username = newUsername, onUsernameChange = {newUsername = it})

        PasswordTextField(label = "Password", password = password, onPasswordChange = {password = it})

        BlueButton(text = "Confirm", onClick = {/*TODO*/})

    }

}
