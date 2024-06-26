package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButtonColumn
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel

@Composable
fun InitialScreen(navController: NavController, themeViewModel: ThemeViewModel) {

    val isSystemInDarkTheme = isSystemInDarkTheme()
    themeViewModel.setDarkTheme(isSystemInDarkTheme)

    BackHandler { }

    ScrollableColumn(arrangement = Arrangement.Center) {

        AppLogo(isDarkTheme = themeViewModel.isDarkTheme)

        BlueButtonColumn(
            navController = navController,
            button1Text = stringResource(id = R.string.SignIn),
            button2Text = stringResource(id = R.string.Register),
            button1Destination = "signIn",
            button2Destination = "register"
        )
    }
}
