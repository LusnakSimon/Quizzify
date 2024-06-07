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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.uniza.quizzify.ui.utils.AnswerButton
import com.uniza.quizzify.ui.utils.BlueIconButton
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.QuestionText
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun QuestionScreen(navController: NavController) {

    ScrollableColumn {
        CustomTopBar(navController = navController, navigateTo = "categories", title = /*TODO*/"[Category name]")

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.app_logo_text/*TODO*/),
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(5.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        QuestionText(text = /*TODO*/"Question text Question text\nQuestion text Question text")

        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.weight(1f))

        Row(modifier = Modifier.fillMaxWidth(0.85f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Text(text = "Question: 1/10"/*TODO*/, fontSize = 20.sp /*TODO*/)

            Spacer(modifier = Modifier.weight(1f))

            val arrow = Icons.AutoMirrored.Filled.ArrowForward/*TODO*/
            BlueIconButton(width = 60.dp, height = 40.dp, description = "Next", icon = arrow, onClick = {/*TODO*/})


        }

        Spacer(modifier = Modifier.height(10.dp))

        AnswerButton(text = "Answer1"/*TODO*/, onClick = { /*TODO*/ })

        Spacer(modifier = Modifier.height(10.dp))

        AnswerButton(text = "Answer2"/*TODO*/, onClick = { /*TODO*/ })

        Spacer(modifier = Modifier.height(10.dp))

        AnswerButton(text = "Answer3"/*TODO*/, onClick = { /*TODO*/ })

        Spacer(modifier = Modifier.height(10.dp))

        AnswerButton(text = "Answer4"/*TODO*/, onClick = { /*TODO*/ })

        Spacer(modifier = Modifier.height(20.dp))

    }
}

