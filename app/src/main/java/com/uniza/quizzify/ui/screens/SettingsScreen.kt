package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.SettingRow


@Composable
fun SettingsScreen(navController: NavController) {

    BackHandler {
        navController.navigate("mainMenu")
    }

    var darkThemeEnabled by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(false) }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = "Settings")

        SettingRow(

            settingName = "Dark Theme",
            isChecked = darkThemeEnabled,
            onCheckedChange = { darkThemeEnabled = it }
        )

        SettingRow(
            settingName = "Notifications",
            isChecked = notificationsEnabled,
            onCheckedChange = { notificationsEnabled = it }
        )
    }
}

