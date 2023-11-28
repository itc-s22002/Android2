package jp.ac.it_college.std.s22002.weathermap.title

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.ac.it_college.std.s22002.weathermap.R
import jp.ac.it_college.std.s22002.weathermap.ui.theme.WeatherMapTheme
@Composable
fun TitleScene(modifier: Modifier = Modifier, onTitleClick: () -> Unit = {}) {
    Surface(modifier) {
        Column(
            modifier = Modifier.fillMaxWidth().clickable(onClick = onTitleClick),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(vertical = 8.dp),
                fontSize = 45.sp
            )

        }
    }
}
@Preview(showBackground = true, widthDp = 320)
@Composable
fun TitleScenePreview() {
    WeatherMapTheme {
        TitleScene(Modifier.fillMaxSize())
    }
}
