package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton

@Composable
fun InitialScreen(navController: NavController) {

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

        AppLogo(modifier = Modifier.size(400.dp))

        Spacer(modifier = Modifier.height(buttonSpacing))

        BlueButton(text = "Sign In", width = 0.8f, onClick = {navController.navigate("signIn")})

        Spacer(modifier = Modifier.height(buttonSpacing))

        BlueButton(text = "Register", width = 0.8f, onClick = {navController.navigate("register")})

        Spacer(modifier = Modifier.height(buttonSpacing))
    }
}
