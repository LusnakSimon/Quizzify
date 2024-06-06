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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.theme.DarkBlue

@Composable
fun ChangePasswordScreen(navController: NavController) {

    var password by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmNewPassword by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(modifier = Modifier.size(50.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = colorResource(id = R.color.white))
            }
            Box(modifier = Modifier.fillMaxWidth(0.9f),
                contentAlignment = Alignment.Center) {
                Text(text = "Change password", fontSize = 30.sp, color = Color.White)
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.75f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            label = { Text("New password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.75f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = confirmNewPassword,
            onValueChange = { confirmNewPassword = it },
            label = { Text("Confirm new password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.75f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .border(1.dp,Color.Black, RoundedCornerShape(30.dp))
                .fillMaxWidth(0.75f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
                contentColor = Color.White)
        ) {
            Text(text = "Confirm", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}
