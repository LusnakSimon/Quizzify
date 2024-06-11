package com.uniza.quizzify.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question): Long

    @Query("SELECT * FROM questions WHERE categoryId = :categoryId")
    fun getQuestionsByCategory(categoryId: Int): LiveData<List<Question>>
    @Query("SELECT * FROM questions")
    suspend fun getAllQuestionsSync(): List<Question>

    @Query("SELECT COUNT(*) FROM questions WHERE categoryId = :categoryId")
    fun getQuestionCountByCategory(categoryId: Int): LiveData<Int>
}