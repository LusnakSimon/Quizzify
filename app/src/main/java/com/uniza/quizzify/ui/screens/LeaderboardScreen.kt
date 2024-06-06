package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.theme.DarkBlue

@Composable
fun LeaderboardScreen(navController: NavController) {

    val userNames = List(100) { "User $it" }
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
                Text(text = "Leaderboard", fontSize = 35.sp, color = Color.White)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Top 100", fontSize = 30.sp, modifier = Modifier
            .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(5.dp))
            .background(DarkBlue),
            color = Color.White)
        Row(
            modifier = Modifier
                .border(1.dp,Color.Black, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(DarkBlue)
                .fillMaxWidth(0.8f)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Rank", color = Color.White)
            Text(text = "Username", color = Color.White)
            Text(text = "Rating", color = Color.White)
        }
        LazyColumn(
            modifier = Modifier
                .border(1.dp,Color.Black, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFBBCBBB))
                .fillMaxWidth(0.8f)
                .height(500.dp)
                .padding(1.dp)

        ) {
            items(userNames) { user ->
                LeaderboardRow(userName = user)
            }
        }
        Row(
            modifier = Modifier
                .border(1.dp,Color.Black, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF538748))
                .fillMaxWidth(0.8f)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "255.")
            Text(text = "Username")
            Text(text = "100")
        }
        Spacer(modifier = Modifier.height(10.dp))

    }

}

@Composable
fun LeaderboardRow(userName: String) {
    Row(
        modifier = Modifier
            .border(1.dp,Color.Black, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "1. ")
        Text(text = userName)
        Text(text = "100")
    }
}
