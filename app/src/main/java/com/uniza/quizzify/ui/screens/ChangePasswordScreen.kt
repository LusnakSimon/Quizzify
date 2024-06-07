package com.uniza.quizzify.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.ui.utils.BlueButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.PasswordTextField
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun ChangePasswordScreen(navController: NavController) {

    var password by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmNewPassword by remember { mutableStateOf("") }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "profile", title = "Change password", titleSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField(label = "Password", password = password, onPasswordChange = {password = it})

        Spacer(modifier = Modifier.height(10.dp))

        PasswordTextField(label = "New password", password = newPassword, onPasswordChange = {newPassword = it})

        Spacer(modifier = Modifier.height(10.dp))

        PasswordTextField(label = "Confirm new password", password = confirmNewPassword, onPasswordChange = {confirmNewPassword = it})

        Spacer(modifier = Modifier.height(20.dp))

        BlueButton(text = "Confirm", onClick = {/*TODO*/})

        Spacer(modifier = Modifier.height(20.dp))
    }
}
