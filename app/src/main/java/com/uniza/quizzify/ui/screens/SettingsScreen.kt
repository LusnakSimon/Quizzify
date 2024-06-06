package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.CustomTopBar


@Composable
fun SettingsScreen(navController: NavController) {
    var darkThemeEnabled by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

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

@Composable
fun SettingRow(settingName: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = settingName, fontSize = 25.sp)

        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange

        )
    }
}