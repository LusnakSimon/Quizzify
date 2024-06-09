package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.data.User
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.Leaderboard
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.LeaderboardViewModel

@Composable
fun LeaderboardScreen(navController: NavController, leaderboardViewModel: LeaderboardViewModel) {

    BackHandler {
        navController.navigate("mainMenu")
    }

    val users = List(100) { User(userId = 0, username = "Username", password = "123", rating = 0) }
    val user = User(userId = 0, username = "Username", password = "123", rating = 0)

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = stringResource(
            id = R.string.Leaderboard
        ))

        Leaderboard(users = users, user = user)

    }
}

