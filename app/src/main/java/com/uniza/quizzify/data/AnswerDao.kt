package com.uniza.quizzify.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnswerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswer(answer: Answer): Long

    @Query("SELECT * FROM answers WHERE questionId = :questionId")
    fun getAnswersByQuestion(questionId: Int): LiveData<List<Answer>>
    @Query("SELECT * FROM answers")
    suspend fun getAllAnswersSync(): List<Answer>
}