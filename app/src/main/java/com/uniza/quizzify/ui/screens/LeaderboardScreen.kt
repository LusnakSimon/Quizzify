package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.LeaderboardViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.Leaderboard
import com.uniza.quizzify.ui.utils.ScrollableColumn
import kotlinx.coroutines.launch

@Composable
fun LeaderboardScreen(
    navController: NavController,
    leaderboardViewModel: LeaderboardViewModel,
    userViewModel: UserViewModel
) {

    val topUsers by leaderboardViewModel.topUsers.observeAsState(emptyList())
    val currentUser by userViewModel.user

    val coroutineScope = rememberCoroutineScope()


    BackHandler {
        navController.navigate("mainMenu")
    }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = stringResource(
            id = R.string.Leaderboard
        ))

        currentUser?.let { Leaderboard(users = topUsers, currentUser = it) {
            coroutineScope.launch {
                if (it == currentUser!!.username) {
                    userViewModel.setLastVisitedScreen("leaderboard")
                    navController.navigate("profile")
                } else {
                    userViewModel.getOtherUser(it) {

                        navController.navigate("details")
                    }
                }
            }
        } }

    }
}

