package jp.ac.it_college.std.s22002.weathermap

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.ac.it_college.std.s22002.weathermap.city.SelectCityScene
import jp.ac.it_college.std.s22002.weathermap.title.TitleScene

object Destinations{
    const val TITLE = "title"
    const val CITY = "city_select"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherMapNavigation(
    navController: NavHostController = rememberNavController(),
){
    var titleText by remember { mutableStateOf("") }
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
                        navController.navigate(Destinations.CITY)
                    }
                )
            }

            composable(Destinations.CITY) {
                titleText = stringResource(id = R.string.please_select_city)
                SelectCityScene()
            }
        }
    }
}