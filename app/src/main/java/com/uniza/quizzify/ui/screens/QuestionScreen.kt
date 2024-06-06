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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.ui.theme.DarkBlue

@Composable
fun QuestionScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
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
            IconButton(onClick = { navController.navigate("categories") }) {
                Icon(modifier = Modifier.size(50.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = colorResource(id = R.color.white)
                )
            }
            Box(modifier = Modifier.fillMaxWidth(0.9f),
                contentAlignment = Alignment.Center) {
                Text(text = "Category name", fontSize = 35.sp, color = Color.White)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.app_logo_text),
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Question text Question text\nQuestion text Question text\nQuestion text Question text",
                    fontSize = 25.sp)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth(0.85f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Text(text = "Question: 1/10", fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier
                .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
                .height(40.dp)
                .width(60.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(colorResource(id = R.color.dark_blue))
                .clickable { /*TODO*/ },
                contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Sign out",
                    tint = colorResource(id = R.color.white)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        AnswerButton(text = "Answer1", onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(10.dp))
        AnswerButton(text = "Answer2", onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(10.dp))
        AnswerButton(text = "Answer3", onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(10.dp))
        AnswerButton(text = "Answer4", onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(20.dp))
    }
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