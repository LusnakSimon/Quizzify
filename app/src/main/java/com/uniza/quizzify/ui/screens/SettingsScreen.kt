package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.SettingRow
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(navController: NavController, settingsViewModel: SettingsViewModel) {

    val darkTheme by settingsViewModel.darkTheme
    val notifications by settingsViewModel.notifications

    BackHandler {
        navController.navigate("mainMenu")
    }



    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = stringResource(
            id = R.string.Settings
        ))

        SettingRow(

            settingName = stringResource(id = R.string.DarkTheme),
            isChecked = darkTheme,
            onCheckedChange = { settingsViewModel.toggleDarkTheme() }
        )

        SettingRow(
            settingName = stringResource(id = R.string.Notifications),
            isChecked = notifications,
            onCheckedChange = { settingsViewModel.toggleNotifications() }
        )
    }
}

