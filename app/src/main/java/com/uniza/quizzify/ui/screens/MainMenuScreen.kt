package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.BlueIconButton
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.SignOutDialog

@Composable
fun MainMenuScreen(navController: NavController) {

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        SignOutDialog(
            onDismiss = { showDialog = false },
            onConfirm = {
                /*TODO sign out*/
                showDialog = false
                navController.navigate("initial")
            }
        )
    }

    BackHandler {
        showDialog = true
    }

    ScrollableColumn {

        Spacer(modifier = Modifier.height(20.dp))

        AppLogo(modifier = Modifier.size(400.dp))

        Spacer(modifier = Modifier.height(30.dp))

        BlueButton(text = "Play", onClick = {navController.navigate("categories")})

        Spacer(modifier = Modifier.height(30.dp))

        BlueButton(text = "Leaderboard", onClick = {navController.navigate("leaderboard")})

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.75f),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val so = Icons.AutoMirrored.Filled.ExitToApp/*TODO*/
            BlueIconButton(width = 80.dp, height = 80.dp, description = "Sign out", icon = so, onClick = {showDialog = true})
            val po = Icons.Default.Person/*TODO*/
            BlueIconButton(width = 80.dp, height = 80.dp, description = "Profile", icon = po, onClick = {navController.navigate("profile")})
            val st = Icons.Default.Settings/*TODO*/
            BlueIconButton(width = 80.dp, height = 80.dp, description = "Settings", icon = st, onClick = {navController.navigate("settings")})
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = /*TODO*/"Signed in as username ", fontSize = 18.sp, color = Color.Gray/*TODO*/)

        Spacer(modifier = Modifier.height(20.dp))

    }
}


