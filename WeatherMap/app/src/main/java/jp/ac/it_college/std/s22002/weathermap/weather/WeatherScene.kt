package jp.ac.it_college.std.s22002.weathermap.weather

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.ac.it_college.std.s22002.weathermap.R
import jp.ac.it_college.std.s22002.weathermap.api.model.Weather
import jp.ac.it_college.std.s22002.weathermap.api.model.Main
import jp.ac.it_college.std.s22002.weathermap.ui.theme.WeatherMapTheme


@Composable
fun WeatherScene(modifier: Modifier = Modifier) {
    var weatherList by remember { mutableStateOf<Main?>(null) }
    Surface(modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text ="\"Temperature: ${weatherList?.temp} °C\""
            )

        }
    }
}



@Preview(showBackground = true, widthDp = 320)
@Composable
fun WeatherScenePreview() {
    WeatherMapTheme {
        WeatherScene(Modifier.fillMaxSize())
    }
}