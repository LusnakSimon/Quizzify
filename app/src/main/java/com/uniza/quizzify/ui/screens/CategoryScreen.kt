package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.CardItem
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ResetDialog
import com.uniza.quizzify.ui.utils.ScrollableCategoryColumn
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.screens.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(navController: NavController, categoryViewModel: CategoryViewModel) {

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

        CustomTopBar(
            spacing = 0.dp,
            navController = navController,
            navigateTo = "mainMenu",
            title = stringResource(id = R.string.Categories)
        )

        ScrollableCategoryColumn(
            items = categories,
            onItemClick = {/*TODO*/navController.navigate("question") },
            onResetClick = {showDialog = true}
        )
    }
}






