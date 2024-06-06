package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar

@Composable
fun ProfileScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        CustomTopBar(navController = navController, navigateTo = "mainMenu", title = "Profile")

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.app_logo_text),
            contentDescription = "App Logo",
            modifier = Modifier.fillMaxSize(0.75f)
            )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text ="Username", fontSize = 30.sp /*TODO*/)

        Text(text ="Your rating: 100" /*TODO*/)

        Spacer(modifier = Modifier.height(20.dp))

        BlueButton(text = "Change username", width = 0.75f, onClick = {navController.navigate("changeUsername")})

        Spacer(modifier = Modifier.height(20.dp))

        BlueButton(text = "Change password", width = 0.75f, onClick = {navController.navigate("changePassword")})

        Spacer(modifier = Modifier.height(20.dp))
    }
}
