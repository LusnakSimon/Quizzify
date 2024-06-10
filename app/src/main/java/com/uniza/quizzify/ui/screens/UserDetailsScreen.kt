package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.BlueButtonColumn
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ProfileImage
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UserProfileInfo

@Composable
fun UserDetailsScreen(navController: NavController, userViewModel: UserViewModel) {

    val user by userViewModel.otherUser

    BackHandler {
        navController.navigate("leaderboard")
    }

    ScrollableColumn {

        user?.let { CustomTopBar(navController = navController, navigateTo = "leaderboard", title = it.username) }

        ProfileImage()

        user?.let { UserProfileInfo(username = it.username, rating = it.rating) }

    }

}