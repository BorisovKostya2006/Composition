package com.example.composition.data

import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.entity.Level
import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {
    const val MIN_SUM_VALUE = 2
    override fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE,maxSumValue)
        val visibleNumber = Random.nextInt(MIN_SUM_VALUE, sum)
        val options = HashSet<Int>()
        options.add(sum-visibleNumber)
        while (options.size != countOfOptions) {
            options.add(Random.nextInt(MIN_SUM_VALUE, maxSumValue))
        }
        return Question(sum,visibleNumber,options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when(level){
            Level.TEST -> {
                GameSettings(10, 3, 50, 8)
            }
            Level.EASY -> {
                GameSettings(10, 10, 70, 60)
            }
            Level.NORMAL -> {
                GameSettings(20, 20, 80, 40)
            }
            Level.HARD -> {
                GameSettings(30, 30, 90, 40)
            }
        }
    }
}