package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButtonColumn
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun InitialScreen(navController: NavController) {

    BackHandler { }

    ScrollableColumn {

        AppLogo()

        BlueButtonColumn(
            navController = navController,
            button1Text = "Sign In",
            button2Text = "Register",
            button1Destination = "signIn",
            button2Destination = "register"
        )
    }
}
