package jp.ac.it_college.std.s22002.prototypepokemonapisampleapi2.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import jp.ac.it_college.std.s22002.prototypepokemonapisampleapi2.db.Pokemon


@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAll(): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE generation = :generation")
    fun findByGeneration(generation: Int): List<Pokemon>

    @Insert
    fun insert(pokemon: Pokemon)

    @Query("DELETE FROM pokemon")
    fun delete()
}