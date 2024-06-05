package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.theme.DarkBlue


@Composable
fun SettingsScreen(navController: NavController) {
    var darkThemeEnabled by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(false) }
    var soundEnabled by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.height(75.dp).fillMaxSize().background(DarkBlue),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(modifier = Modifier.size(50.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = colorResource(id = R.color.white))
            }
            Text(text = "Settings", fontSize = 35.sp, color = Color.White)

            Icon(modifier = Modifier.size(50.dp),
                 imageVector = Icons.Default.Settings,
                 contentDescription = "Settings",
                 tint = colorResource(id = R.color.white))

        }
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
        SettingRow(
            settingName = "Sound",
            isChecked = soundEnabled,
            onCheckedChange = { soundEnabled = it }
        )
        Spacer(modifier = Modifier.weight(0.8f))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
                contentColor = Color.White)
        ) {
            Text(text = "Save", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
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
        Text(text = settingName)

        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange

        )
    }
}