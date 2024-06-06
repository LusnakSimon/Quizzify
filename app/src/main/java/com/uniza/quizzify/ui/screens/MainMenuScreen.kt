package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun MainMenuScreen(navController: NavController) {
    val logoPadding = 8.dp
    val buttonSpacing = 30.dp

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(logoPadding)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logo_text),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(400.dp)
        )

        Spacer(modifier = Modifier.height(buttonSpacing))

        Button(
            onClick = { navController.navigate("categories") },
            modifier = Modifier
                .border(1.dp,Color.Black, RoundedCornerShape(30.dp))
                .fillMaxWidth(0.75f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
                contentColor = Color.White)
        ) {
            Text(text = "Play", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(buttonSpacing))

        Button(
            onClick = { navController.navigate("leaderboards") },
            modifier = Modifier
                .border(1.dp,Color.Black, RoundedCornerShape(30.dp))
                .fillMaxWidth(0.75f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
                contentColor = Color.White)
        ) {
            Text(text = "Leaderboard", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(buttonSpacing))
        Row(
            modifier = Modifier.fillMaxWidth(0.75f),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(12.dp))
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorResource(id = R.color.dark_blue))
                    .clickable { navController.navigate("initial")},
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "Sign out",
                    tint = colorResource(id = R.color.white)
                )
            }

            Box(
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(12.dp))
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorResource(id = R.color.dark_blue))
                    .clickable { navController.navigate("profile") },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = colorResource(id = R.color.white)
                )
            }

            Box(
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(12.dp))
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(colorResource(id = R.color.dark_blue))
                    .clickable { navController.navigate("settings") },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = colorResource(id = R.color.white)
                )
            }
        }
        Spacer(modifier = Modifier.height(buttonSpacing))
        Text(text = "Signed in as username ", fontSize = 18.sp, color = Color.Gray)
    }
}
