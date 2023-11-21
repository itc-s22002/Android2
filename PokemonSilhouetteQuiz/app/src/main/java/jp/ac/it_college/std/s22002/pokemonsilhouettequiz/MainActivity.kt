package jp.ac.it_college.std.s22002.pokemonsilhouettequiz

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.database.PokeRoomDatabase
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.database.entity.Poke
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.ui.theme.PokemonSilhouetteQuizTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scope = rememberCoroutineScope()
            val context = LocalContext.current

            scope.launch {
                testDataInitializeDatabase(context)
            }
            PokemonSilhouetteQuizTheme {
                PokeNavigation()
            }
        }
    }
}



private suspend fun testDataInitializeDatabase(context: Context){
    withContext(Dispatchers.IO){
        val dao = PokeRoomDatabase.getDatabase(context).pokeDao()
        if (dao.findByGeneration(9).isNotEmpty()) return@withContext
        dao.insertAll(
            listOf(
                Poke(
                    906,
                    9,
                    "ニャオハ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/906.png"
                ),
                Poke(
                    909,
                    9,
                    "ホゲータ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/909.png"
                ),
                Poke(
                    912,
                    9,
                    "クワッス",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/912.png"
                ),
                Poke(
                    915,
                    9,
                    "グルトン",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/915.png",
                ),
                Poke(
                    921,
                    9,
                    "パモ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/921.png"
                ),
                Poke(
                    932,
                    9,
                    "コジオ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/924.png"
                ),
                Poke(
                    924,
                    9,
                    "ワッカネズミ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/924.png"
                ),Poke(
                    926,
                    9,
                    "パピモッチ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/926.png"
                ),Poke(
                    928,
                    9,
                    "ミニーブ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/928.png"
                ),Poke(
                    931,
                    9,
                    "イキリインコ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/931.png"
                ),
                Poke(
                    935,
                    9,
                    "カルボウ",
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/935.png"
                ),
            )
        )
    }
}

