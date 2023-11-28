package jp.ac.it_college.std.s22002.pokemonsilhouettequiz.download

import android.content.Context
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.api.GamesGroup
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.api.PokemonGroup
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.database.PokeRoomDatabase
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.database.entity.Poke
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun pokeDataDownload(context: Context, scope: CoroutineScope){
    scope.launch {
        withContext(Dispatchers.IO){
            val data = pokeApi()

            PokeRoomDatabase.getDatabase(context).pokeDao().insertAll(data)

        }
    }
}

fun pokeApi(): List<Poke>{
    val generation  =GamesGroup.getGeneration(9)

    val species = generation.pokemonSpecies.map {
        PokemonGroup.getPokemonSpecies(it)
    }

    val pokemon = species.map {
        PokemonGroup.getPokemon(it.varienties[0].pokemon)
    }

    val dateset = pokemon.map {
        Poke(
            it.id.toLong(),
            9,
            species.find { sp }
        )
    }
}