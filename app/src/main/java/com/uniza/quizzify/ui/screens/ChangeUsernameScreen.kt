package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.ChangeUsernameViewModel

@Composable
fun ChangeUsernameScreen(navController: NavController, changeUsernameViewModel: ChangeUsernameViewModel) {

    val newUsername by changeUsernameViewModel.newUsername
    val password by changeUsernameViewModel.password

    BackHandler {
        navController.navigate("profile")
    }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "profile", title = stringResource(
            id = R.string.ChangeUsername
        ), titleSize = 30.sp)

        UsernameTextField(
            label = stringResource(id = R.string.NewUsername),
            username = newUsername,
            onUsernameChange = {changeUsernameViewModel.setNewUsername(it)}
        )

        PasswordTextField(
            label = stringResource(id = R.string.Password),
            password = password,
            onPasswordChange = {changeUsernameViewModel.setPassword(it)}
        )

        BlueButton(text = stringResource(id = R.string.Confirm), onClick = {/*TODO*/})

    }

}
