package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.ResetDialog

@Composable
fun CategoryScreen(navController: NavController) {

    val scrollState = rememberScrollState()

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = "Categories")

        val sampleItems = List(10) {/*TODO remove later*/
            CardItem(
                title = "Category $it",
                description = "$it/10",
                imageResId = android.R.drawable.ic_menu_camera
            )
        }
        ScrollableCategoryColumn(items = sampleItems,
            onItemClick = {/*TODO*/navController.navigate("question")
        }, {showDialog = true})

    }
}

@Composable
fun ScrollableCategoryColumn(/*TODO*/items: List<CardItem>, onItemClick: (CardItem) -> Unit, onResetClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(1000.dp),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { item ->
            CategoryCard(item = item, onClick = { onItemClick(item) }, onResetClick)
        }

    }
}

@Composable
fun CategoryCard(/*TODO*/item: CardItem, onClick: () -> Unit, onResetClick: () -> Unit) {
    Card(
        modifier = Modifier
            .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .clickable { onClick() }
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painterResource(id = R.drawable.app_logo_text),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = item.title, fontSize = 35.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = item.description, fontSize = 20.sp, color = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = { onResetClick() }) {
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Reset",
                        tint = colorResource(id = R.color.black)
                    )
                }
            }

        }
    }
}



data class CardItem(/*TODO remove later*/
    val title: String,
    val description: String,
    val imageResId: Int
)




