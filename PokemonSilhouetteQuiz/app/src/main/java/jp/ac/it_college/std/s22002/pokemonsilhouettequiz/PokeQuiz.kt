package jp.ac.it_college.std.s22002.pokemonsilhouettequiz

import android.icu.lang.UProperty.NameChoice

data class PokeQuiz(
    val imageUrl: String,
    val choice: List<String>,
    val correct: String
)
