package jp.ac.it_college.std.s22002.pokemonsilhouettequiz.quiz

import android.icu.lang.UProperty.NameChoice
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s22002.pokemonsilhouettequiz.ui.theme.PokemonSilhouetteQuizTheme

@Composable
fun QuizScene (
    imageUrl: String,
    choices: NameChoice,
    modifier: Modifier = Modifier
){
    Surface (modifier){
        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            PokeImage(imageUrl)
            PokeNameList(choices)
        }
    }
}

@Composable
fun PokeImage(imageUrl: String, isSilhouette: Boolean = true){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
            horizontalAlignment = Alignement.CenterHorizontally

    ){
        Box (
            modifier = Modifier
                .size(240.dp)
                .clip(RoundedCornerShape(20))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ){
            AsyncImage(model = imageUrl, contentDes)
        }

    }

}

@Composable
fun PokeName(name: String){
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Button (
            onClick = {},
            modifier = Modifier
                .padding(8.dp)
        ){
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )

        }

    }
}

@Composable
fun PokeNameList(items: List<String>){
    LazyColumn(){
        items(items.shuffled()){
            PokeName(name = it)
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun QuizScenePreview(){
    PokemonSilhouetteQuizTheme {
        QuizScene(
            imageUrl = "",
            choices = listOf("ニャオハ", "ホゲータ", "クワッス", "グルトン"),
            modifier = Modifier.fillMaxWidth()
        )

    }
}