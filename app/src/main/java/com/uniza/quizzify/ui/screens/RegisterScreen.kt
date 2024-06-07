package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.AppLogo
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn
import com.uniza.quizzify.ui.utils.UsernameTextField

@Composable
fun RegisterScreen(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "initial", title = "Register")

        Spacer(modifier = Modifier.height(10.dp))

        AppLogo(modifier = Modifier.size(370.dp))

        Spacer(modifier = Modifier.height(20.dp))
        
        UsernameTextField(label = "Username", username = username, onUsernameChange = {username = it})
    
        Spacer(modifier = Modifier.height(10.dp))

        PasswordTextField(label = "Password", password = password, onPasswordChange = {password = it})

        Spacer(modifier = Modifier.height(10.dp))

        PasswordTextField(label = "Confirm password", password = confirmPassword, onPasswordChange = {confirmPassword = it})

        Spacer(modifier = Modifier.height(20.dp))

        BlueButton(text = "Register", onClick = {navController.navigate("mainMenu")})

        Spacer(modifier = Modifier.height(20.dp))
    }
}
