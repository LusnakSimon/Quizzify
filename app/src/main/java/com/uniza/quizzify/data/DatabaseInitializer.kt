package com.uniza.quizzify.data

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.uniza.quizzify.R

class DatabaseInitializer(
    private val context: Context,
    private val categoryRepository: CategoryRepository,
    private val questionRepository: QuestionRepository,
    private val answerRepository: AnswerRepository
) {

    suspend fun initialize() {
        withContext(Dispatchers.IO) {
            if (categoryRepository.getAllCategoriesSync().isEmpty() &&
                questionRepository.getAllQuestionsSync().isEmpty() &&
                answerRepository.getAllAnswersSync().isEmpty()) {
                insertInitialData()
            }
        }
    }

    private suspend fun insertInitialData() {
        val categories: List<CategoryJson> = loadJsonData(R.raw.categories)
        val questions: List<QuestionJson> = loadJsonData(R.raw.questions)
        val answers: List<AnswerJson> = loadJsonData(R.raw.answers)

        categories.forEach {
            categoryRepository.insertCategory(Category(it.categoryId, it.categoryName, it.description, it.imageId))
        }
        questions.forEach {
            questionRepository.insertQuestion(Question(it.questionId, it.categoryId, it.questionText, it.imageId))
        }
        answers.forEach {
            answerRepository.insertAnswer(Answer(it.answerId, it.questionId, it.answerText, it.isCorrect))
        }
    }

    private inline fun <reified T> loadJsonData(resourceId: Int): List<T> {
        val jsonString = context.resources.openRawResource(resourceId).bufferedReader().use { it.readText() }
        return Json.decodeFromString<List<T>>(jsonString)
    }
}
