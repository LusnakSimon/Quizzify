package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.SignInViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.ErrorMessage
import com.uniza.quizzify.ui.utils.SignInUtils
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(navController: NavController, signInViewModel: SignInViewModel, userViewModel: UserViewModel) {

    val coroutineScope = rememberCoroutineScope()

    val errorMessage by signInViewModel.errorMessage
    val showErrorText by signInViewModel.showErrorText
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

        if(showErrorText) {
            ErrorMessage(text = errorMessage)
        }

        UsernameTextField(
            label = stringResource(id = R.string.Username),
            username = username,
            onUsernameChange = { signInViewModel.setUsername(it) }
        )

        PasswordTextField(
            label = stringResource(id = R.string.Password),
            password = password,
            action = ImeAction.Done,
            onPasswordChange = {signInViewModel.setPassword(it)}
        )

        BlueButton(
            text = stringResource(id = R.string.SignIn),
            onClick = {
                coroutineScope.launch {
                    SignInUtils.performSignIn(
                        username = username,
                        password = password,
                        userViewModel = userViewModel,
                        signInViewModel = signInViewModel,
                        navController = navController
                    )
                }
            }
        )
    }
}

