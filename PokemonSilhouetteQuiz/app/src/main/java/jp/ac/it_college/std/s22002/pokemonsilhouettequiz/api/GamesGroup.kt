package jp.ac.it_college.std.s22002.pokemonsilhouettequiz.api

import io.ktor.client.call.body
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.api.model.Generation

object GamesGroup {
    suspend fun getGeneration(gen: Int): Generation {
        return Client.get("/generation/$gen/").body()
    }
}