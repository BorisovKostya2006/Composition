package com.example.composition.domain.useCases

import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {
    operator fun invoke(maxSumValue : Int): Question {
        return repository.generateQuestion(maxSumValue,COUNT_OF_OPTIONS)
    }
    companion object{
        const val COUNT_OF_OPTIONS = 6
    }
}