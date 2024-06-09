package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.BlueButtonColumn
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ProfileImage
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UserProfileInfo
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel

@Composable
fun ProfileScreen(navController: NavController, userViewModel: UserViewModel) {

    val user by userViewModel.user

    BackHandler {
        navController.navigate("mainMenu")
    }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = stringResource(
            id = R.string.Profile
        ))

        ProfileImage(painter = painterResource(id = android.R.drawable.ic_menu_camera)/*TODO*/)

        user?.let { UserProfileInfo(username = it.username, rating = it.rating) }

        BlueButtonColumn(
            navController= navController,
            button1Text = stringResource(id = R.string.ChangeUsername),
            button2Text = stringResource(id = R.string.ChangePassword),
            button1Destination = "changeUsername",
            button2Destination = "changePassword"
        )
    }
}
