package jp.ac.it_college.std.s22002.prototypepokemonapisampleapi2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import jp.ac.it_college.std.s22002.prototypepokemonapisampleapi2.model.Generation

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey val id: Int,
    val generation: Int,
    val name: String,
    @ColumnInfo(name = "main_texture_url") val mainTextUrl: String
)
