package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButtonColumn
import com.uniza.quizzify.ui.utils.BlueIconButtonRow
import com.uniza.quizzify.ui.utils.CurrentUserText
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.SignOutDialog
import com.uniza.quizzify.R
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

        AppLogo()

        BlueButtonColumn(
            navController = navController,
            button1Text = stringResource(id = R.string.Play),
            button2Text = stringResource(id = R.string.Leaderboard),
            button1Destination = "categories",
            button2Destination = "leaderboard"
        )

        BlueIconButtonRow(
            onSignOutClick = { showDialog = true },
            onProfileClick = { navController.navigate("profile") },
            onSettingsClick = { navController.navigate("settings") }
        )

        CurrentUserText("username")

    }
}


