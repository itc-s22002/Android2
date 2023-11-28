package jp.ac.it_college.std.s22002.pokemonsilhouettequiz.api.model

import kotlinx.serialization.Serializable



@Serializable
data class PokemonSpecies (
    val id: Int,
    val names: List<Name>,
    val variable: List<PokemonSpeciesVariety>
)