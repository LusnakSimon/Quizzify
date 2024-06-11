package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.MainMenuViewModel
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButtonColumn
import com.uniza.quizzify.ui.utils.BlueIconButtonRow
import com.uniza.quizzify.ui.utils.CurrentUserText
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.SignOutDialog
import kotlinx.coroutines.launch

@Composable
fun MainMenuScreen(
    navController: NavController,
    mainMenuViewModel: MainMenuViewModel,
    userViewModel: UserViewModel,
    themeViewModel: ThemeViewModel
) {


    val coroutineScope = rememberCoroutineScope()

    val showDialog by mainMenuViewModel.showDialog

    val user by userViewModel.user
    user?.let { themeViewModel.setDarkTheme(it.darkMode) }

    val isSystemDarkTheme = isSystemInDarkTheme()

    if (showDialog) {
        SignOutDialog(
            onDismiss = { mainMenuViewModel.toggleShowDialog() },
            onConfirm = {
                coroutineScope.launch {
                    userViewModel.signOut()
                    mainMenuViewModel.toggleShowDialog()
                    navController.navigate("initial")
                    themeViewModel.setDarkTheme(isSystemDarkTheme)
                }
            }
        )
    }

    BackHandler {
        mainMenuViewModel.toggleShowDialog()
    }

    ScrollableColumn(arrangement = Arrangement.Center) {

        AppLogo(size = 370.dp, isDarkTheme = themeViewModel.isDarkTheme)

        BlueButtonColumn(
            navController = navController,
            button1Text = stringResource(id = R.string.Play),
            button2Text = stringResource(id = R.string.Leaderboard),
            button1Destination = "categories",
            button2Destination = "leaderboard"
        )

        BlueIconButtonRow(
            onSignOutClick = { mainMenuViewModel.toggleShowDialog() },
            onProfileClick = {
                userViewModel.setLastVisitedScreen("mainMenu")
                navController.navigate("profile") },
            onSettingsClick = { navController.navigate("settings") }
        )

        user?.let { CurrentUserText(it.username) }

    }
}


