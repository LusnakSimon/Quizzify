package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.CategoryViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserProgressViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ResetDialog
import com.uniza.quizzify.ui.utils.ScrollableCategoryColumn
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun CategoryScreen(
    navController: NavController,
    categoryViewModel: CategoryViewModel,
    userProgressViewModel: UserProgressViewModel,
    userViewModel: UserViewModel
    ) {

    val categories by categoryViewModel.categories.observeAsState(emptyList())

    val showDialog by categoryViewModel.showDialog
    val selectedCategory by categoryViewModel.selectedCategory

    val userProgressList by userProgressViewModel.userProgressList.observeAsState(emptyList())

    val user by userViewModel.user

    BackHandler {
        navController.navigate("mainMenu")
    }


    if (showDialog) {
        ResetDialog(
            onDismiss = { categoryViewModel.dismissDialog() },
            onConfirm = {
                selectedCategory?.let { category ->
                    user?.let { user ->
                        userProgressViewModel.resetProgress(user.userId, category.categoryId)
                    }
                }
                categoryViewModel.dismissDialog()
            }
        )
    }

    ScrollableColumn {

        CustomTopBar(
            spacing = 0.dp,
            navController = navController,
            navigateTo = "mainMenu",
            title = stringResource(id = R.string.Categories)
        )

        user?.let {currentUser ->
            userProgressViewModel.fetchUserProgress(currentUser.userId)
            ScrollableCategoryColumn(
                items = categories,
                onItemClick = { category -> navController.navigate("question/${category.categoryId}") },
                onResetClick = { category -> categoryViewModel.showResetDialog(category) },
                categoryViewModel = categoryViewModel,
                userProgressList = userProgressList,
                user = currentUser,
                userProgressViewModel = userProgressViewModel
            )

        }
    }
}






