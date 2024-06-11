package com.uniza.quizzify.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.uniza.quizzify.ui.screens.viewmodel.CategoryViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserProgressViewModel
import com.uniza.quizzify.ui.screens.viewmodel.UserViewModel
import com.uniza.quizzify.ui.utils.AnswerButtons
import com.uniza.quizzify.ui.utils.CategoryProgress
import com.uniza.quizzify.ui.utils.CustomTopBar
import com.uniza.quizzify.ui.utils.QuestionImage
import com.uniza.quizzify.ui.utils.QuestionText
import com.uniza.quizzify.ui.utils.ScrollableColumn

@Composable
fun QuestionScreen(
    navController: NavController,
    categoryId : Int,
    userProgressViewModel: UserProgressViewModel,
    userViewModel: UserViewModel,
    categoryViewModel : CategoryViewModel
) {

    val user by userViewModel.user

    val categories by categoryViewModel.categories.observeAsState(emptyList())

    LaunchedEffect(categories, user?.userId) {
        user?.let { userProgressViewModel.fetchAllProgressData(it.userId, categories) }
    }

    val answeredQuestionsInCategoryCount by userProgressViewModel.answeredQuestionsInCategoryCount.observeAsState(emptyMap())
    val totalQuestionsInCategoryCount by userProgressViewModel.totalQuestionsInCategoryCount.observeAsState(emptyMap())

    val progress = answeredQuestionsInCategoryCount[categoryId] ?: 0
    val questionsTotal = totalQuestionsInCategoryCount[categoryId] ?: 0
    
    BackHandler {
        navController.navigate("categories")
    }

    ScrollableColumn {

        CustomTopBar(navController = navController, navigateTo = "categories", title = /*TODO*/"$categoryId")

        CategoryProgress(questionNumber = progress, questionsTotal = questionsTotal)

        QuestionImage(painter = painterResource(id = android.R.drawable.ic_menu_camera/*TODO*/))

        QuestionText(text = /*TODO*/"Question text Question text\nQuestion text Question text")

        AnswerButtons(
            answer1Text = "Answer1"/*TODO*/,
            answer2Text = "Answer2"/*TODO*/,
            answer3Text = "Answer3"/*TODO*/,
            answer4Text = "Answer4"/*TODO*/,
            onAnswer1Click = { /*TODO*/ },
            onAnswer2Click = { /*TODO*/ },
            onAnswer3Click = { /*TODO*/ },
            onAnswer4Click = { /*TODO*/ }
        )
    }
}

