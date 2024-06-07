package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
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
import com.uniza.quizzify.ui.theme.QuizzifyTheme
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun InitialScreen(navController: NavController) {

    BackHandler {}
    QuizzifyTheme {

    }
    ScrollableColumn {

        Spacer(modifier = Modifier.height(30.dp))

        AppLogo(modifier = Modifier.size(400.dp))

        Spacer(modifier = Modifier.height(50.dp))

        BlueButton(text = "Sign In", onClick = {navController.navigate("signIn")})

        Spacer(modifier = Modifier.height(30.dp))

        BlueButton(text = "Register", onClick = {navController.navigate("register")})

        Spacer(modifier = Modifier.height(50.dp))
    }
}
