package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R

@Composable
fun InitialScreen(navController: NavController) {

    val logoPadding = 8.dp
    val buttonSpacing = 40.dp

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
            onClick = { navController.navigate("signIn") },
            modifier = Modifier.fillMaxWidth(0.8f).height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
                contentColor = Color.White)
        ) {
            Text(text = "Sign In", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(buttonSpacing))

        Button(
            onClick = { navController.navigate("register") },
            modifier = Modifier.fillMaxWidth(0.8f).height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
                contentColor = Color.White)
        ) {
            Text(text = "Register", fontSize = 18.sp)
        }
    }
}
