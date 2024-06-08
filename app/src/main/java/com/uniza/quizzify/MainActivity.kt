package com.uniza.quizzify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.uniza.quizzify.ui.navigation.NavigationGraph
import com.uniza.quizzify.ui.theme.QuizzifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzifyTheme {

                NavigationGraph()

            }
        }
    }
}
