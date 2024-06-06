package com.uniza.quizzify.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.theme.DarkBlue

@Composable
fun CategoryScreen(navController: NavController) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .border(1.dp, Color.Black, RectangleShape)
                .height(75.dp)
                .fillMaxSize()
                .background(DarkBlue),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            IconButton(onClick = { navController.navigate("mainMenu") }) {
                Icon(modifier = Modifier.size(50.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = colorResource(id = R.color.white))
            }
            Box(modifier = Modifier.fillMaxWidth(0.9f),
                contentAlignment = Alignment.Center) {
                Text(text = "Categories", fontSize = 35.sp, color = Color.White)
            }

        }
        val sampleItems = List(10) {
            CardItem(
                title = "Category $it",
                description = "$it/10",
                imageResId = android.R.drawable.ic_menu_camera
            )
        }
        ScrollableCardColumn(items = sampleItems, onItemClick = {navController.navigate("question")})

    }
}

@Composable
fun ScrollableCardColumn(items: List<CardItem>, onItemClick: (CardItem) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(1000.dp),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { item ->
            CardItemComposable(item = item, onClick = { onItemClick(item) })
        }

    }
}

@Composable
fun CardItemComposable(item: CardItem, onClick: () -> Unit) {
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
                IconButton(onClick = { Log.d("reset button", "reset button clicked") }) {
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

data class CardItem(
    val title: String,
    val description: String,
    val imageResId: Int
)




