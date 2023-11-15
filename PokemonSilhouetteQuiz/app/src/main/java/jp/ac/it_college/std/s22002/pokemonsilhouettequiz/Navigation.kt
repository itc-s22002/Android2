package jp.ac.it_college.std.s22002.pokemonsilhouettequiz

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.generation.SelectGenerationScene
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.quiz.QuizScene
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.result.ResultScene
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.title.TitleScene

object Destinations{
    const val TITLE = "title"
    const val GENERATION = "generation_select"
    const val QUIZ = "quiz/{order}"
    const val RESULT = "result"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeNavigation(
    navController: NavHostController = rememberNavController(),
) {
    var titleText by remember { mutableStateOf("") }
    var quizDate by remember {
        mutableStateOf(listOf<PokeQuiz>())
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = titleText)
            })
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Destinations.TITLE,
            modifier = Modifier.padding(it)
        ) {
            composable(Destinations.TITLE) {
                titleText = ""
                TitleScene(
                    onTitleClick = {
                        navController.navigate(Destinations.GENERATION)
                    }
                )
            }

            composable(Destinations.GENERATION) {
                titleText = stringResource(id = R.string.pleas_select_generation)
                SelectGenerationScene(onGenerationSelected = {gen ->
                    quizDate = generationQuizData(gen)
                    navController.navigate("quiz/0")
                })
            }

            composable(
                Destinations.QUIZ,
                arguments = listOf(navArgument("order"){type = NavType.IntType })
                ) {
                titleText = ""
                val order = it.arguments?.getInt("order") ?:0
                QuizScene(quizDate[order])
            }

            composable(Destinations.RESULT) {
                ResultScene(result = 0)
            }
        }
    }
}

fun generationQuizData(generation: Int) :List<PokeQuiz>{
    return  listOf(
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/906.png",
            choice = listOf("ニャオハ", "ホゲータ", "クワッス", "グルトン"),
            correct = "ニャオハ"
        ),
    )
}