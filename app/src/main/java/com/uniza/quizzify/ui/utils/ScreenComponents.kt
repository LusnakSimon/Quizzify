package com.uniza.quizzify.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.theme.DarkBlue

@Composable
fun CustomTopBar(navController : NavController, navigateTo : String, title : String, titleSize: TextUnit = 35.sp) {
    Row(
        modifier = Modifier
            .border(1.dp, Color.Black, RectangleShape)
            .height(75.dp)
            .fillMaxSize()
            .background(DarkBlue),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        IconButton(onClick = { navController.navigate(navigateTo) }) {
            Icon(modifier = Modifier.size(50.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = colorResource(id = R.color.white)
            )
        }
        Box(modifier = Modifier.fillMaxWidth(0.9f),
            contentAlignment = Alignment.Center) {
            Text(text = title, fontSize = titleSize, color = Color.White)
        }

    }
}

@Composable
fun BlueButton(text : String, width : Float, onClick : () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .border(1.dp, Color.Black, RoundedCornerShape(30.dp))
            .fillMaxWidth(width)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
            contentColor = Color.White)
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Composable
fun AppLogo(modifier : Modifier) {
    Image(
        painter = painterResource(id = R.drawable.app_logo_text),
        contentDescription = "App Logo",
        modifier = modifier
    )
}

@Composable
fun AnswerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .border(1.dp, Color.Black, RoundedCornerShape(30.dp))
            .height(60.dp)
            .fillMaxWidth(0.85f),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Composable
fun ResetDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Reset progress") },
        text = { Text(text = "Are you sure you want reset [category name] category progress?") },
        confirmButton = {
            Button(
                onClick = onConfirm
            ) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun SignOutDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Sign Out") },
        text = { Text(text = "Are you sure you want to sign out?") },
        confirmButton = {
            Button(
                onClick = onConfirm
            ) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}
@Composable
fun UsernameTextField() {

}

@Composable
fun PasswordTextField() {

}