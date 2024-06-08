package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.CardItem
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ResetDialog
import com.uniza.quizzify.ui.utils.ScrollableCategoryColumn
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun CategoryScreen(navController: NavController) {

    BackHandler {
        navController.navigate("mainMenu")
    }

    val categories = List(10/*TODO*/) {/*TODO */
        CardItem(
            title = "Category $it",
            progress = 0,
            imageResId = android.R.drawable.ic_menu_camera
        )
    }

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        ResetDialog(
            onDismiss = { showDialog = false },
            onConfirm = {
                showDialog = false
                /*TODO reset progress*/
            }
        )
    }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = "Categories")

        ScrollableCategoryColumn(
            items = categories,
            onItemClick = {/*TODO*/navController.navigate("question") },
            onResetClick = {showDialog = true}
        )
    }
}






