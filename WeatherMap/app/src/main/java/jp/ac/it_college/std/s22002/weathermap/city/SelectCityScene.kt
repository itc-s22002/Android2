package jp.ac.it_college.std.s22002.weathermap.city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s22002.weathermap.ui.theme.WeatherMapTheme

@Composable
fun SelectCityScene(modifier: Modifier = Modifier, onCitySelected: (Int) -> Unit = {}){
    Surface (modifier){
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            item(1) {
                City(
                    cityId = 2130037,
                    cityName = "北海道(札幌)",
                    onCitySelected = onCitySelected
                )
            }
            item(2){
                City(
                    cityId = 2130658,
                    cityName = "青森",
                    onCitySelected = onCitySelected
                )
            }
            item(3){
                City(
                    cityId = 2111834,
                    cityName = "岩手(盛岡)",
                    onCitySelected = onCitySelected
                )
            }
        }
    }
}

@Composable
fun City(cityId: Int, cityName: String, onCitySelected: (Int) -> Unit = {}) {
    Surface(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onCitySelected(cityId) }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)

        ) {
            // 第?世代
            Text(
                text = cityName,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun SelectGenerationScenePreview() {
    WeatherMapTheme {
        SelectCityScene(Modifier.fillMaxSize())
    }
}