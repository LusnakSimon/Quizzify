package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.ThemeViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.SettingRow
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(
    navController: NavController,
    themeViewModel: ThemeViewModel,
    userViewModel: UserViewModel
    ) {

    val coroutineScope = rememberCoroutineScope()

    val user by userViewModel.user

    BackHandler {
        navController.navigate("mainMenu")
    }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = stringResource(
            id = R.string.Settings
        ))

        user?.darkMode?.let {
            SettingRow(
                settingName = stringResource(id = R.string.DarkTheme),
                isChecked = themeViewModel.isDarkTheme.value
            ) {
                coroutineScope.launch {
                    userViewModel.updateUserDarkTheme(it)
                    userViewModel.authenticateUser(user!!.username, user!!.password) {}
                    themeViewModel.setDarkTheme(it)
                }
            }
        }

        user?.notifications?.let {
            SettingRow(
                settingName = stringResource(id = R.string.Notifications),
                isChecked = it
            ) {
                coroutineScope.launch {
                    userViewModel.updateUserNotifications(it)
                    userViewModel.authenticateUser(user!!.username, user!!.password) {}
                }
            }
        }
    }
}

