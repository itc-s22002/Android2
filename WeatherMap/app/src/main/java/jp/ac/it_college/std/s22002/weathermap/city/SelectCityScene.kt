package jp.ac.it_college.std.s22002.weathermap.city

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import jp.ac.it_college.std.s22002.weathermap.api.CityGroup.getCityWeather
import jp.ac.it_college.std.s22002.weathermap.api.model.WeatherList
import jp.ac.it_college.std.s22002.weathermap.ui.theme.WeatherMapTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SelectCityScene(
    modifier: Modifier = Modifier,

){
    val options = mapOf(
        "2130037" to "北海道(札幌)",
        "2130658" to "青森",
        "2111834" to "岩手(盛岡)",
        "2111149" to "宮城(仙台)",
        "2113719" to  "秋田",
        "2110556" to "山形",
        "2112923" to "福島",
        "2111901" to "茨城(水戸)",
        "1849053" to "栃木(宇都宮)",
        "1857843" to "群馬(前橋)",
        "1853226" to "埼玉(さいたま)",
        "2113014" to "千葉",
        "1850144" to "東京",
        "1848354" to "神奈川(横浜)",
        "1855431" to "新潟",
        "1849876" to "富山",
        "1860243" to "石川(金沢)",
        "1863985" to "福井",
        "1859100" to "山梨(甲府)",
        "1856215" to "長野",
        "1863641" to "岐阜",
        "1851717" to "静岡",
        "1865694" to "愛知(名古屋)",
        "1849796" to "三重(津)",
        "1853574" to "滋賀(大津)",
        "1857910" to "京都",
        "1853909" to "大阪",
        "1859171" to "兵庫",
        "1855612" to "奈良",
        "1926004" to "和歌山",
        "1849892" to "鳥取",
        "1857550" to "島根(松江)",
        "1854383" to "岡山",
        "1862415" to "広島",
        "1848689" to "山口",
        "1850158" to "徳島",
        "1851100" to "香川(高松)",
        "1926099" to "愛媛(松山)",
        "1859146" to "高知",
        "1863967" to "福岡",
        "1853303" to "佐賀",
        "1856177" to "長崎",
        "1858421" to "熊本",
        "1854487" to "大分",
        "1856717" to "宮崎",
        "1860827z" to "鹿児島",
        "1856035" to "沖縄"
        )
    var expanded by remember { mutableStateOf(false) }
    var apiTempResult by remember { mutableStateOf(0?.toDouble()) }
    var apiFeelsResult by remember { mutableStateOf(0?.toDouble()) }
    var apiGroundResult by remember { mutableStateOf("") }
    var apiHumidityResult by remember { mutableStateOf("") }
    var apiMainResult by remember { mutableStateOf("") }
    var apiIconResult by remember { mutableStateOf("") }
    var apiSpeedResult by remember { mutableStateOf("") }
    var apiDegResult by remember { mutableStateOf("") }
    var apiGustResult by remember { mutableStateOf("") }
    var apiPercentResult by remember { mutableStateOf("") }
    var apiTimesResult by remember { mutableStateOf("") }
    var apiSnowResult by remember { mutableStateOf("") }

    var isVisible by remember { mutableStateOf(false) }

    var apiIntTempResult by remember { mutableStateOf(0?.toInt())}
    var apiIntFeelsResult by remember { mutableStateOf(0?.toInt())}

    var apiListResult by remember { mutableStateOf<WeatherList?>(null)}

    var selectCity by remember { mutableStateOf(options["2130037"])}

    var isSelectCity by remember { mutableStateOf(false) }


    var selectId by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()


    Surface (modifier){
        Column (modifier = Modifier.fillMaxWidth()){
            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.TopStart)
                    .height(56.dp)
                    .fillMaxWidth(),
                contentAlignment =  Alignment.Center

            ){
                Text(
                    text = "3時間毎5日間の天気予報",
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )
            }
                Box(
                    modifier = Modifier
                        .wrapContentSize(Alignment.TopStart)
                        .height(56.dp)
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable {
                            expanded = true
                        }
                        .fillMaxWidth()
                ){
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if(isSelectCity){
                            Text(text = selectCity.toString(), color = Color.White)
                        }else{
                            Text(text = "都道府県を選んでください", color = Color.White)
                        }
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.White)
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false},
                        modifier = Modifier.padding(16.dp)
                    ) {
                        options.forEach {(key, value) ->
                            DropdownMenuItem(text = { Text(text = options[key].toString())},
                                onClick = {
                                    selectId = key
                                    scope.launch {
                                        apiListResult = getCityWeather(selectId)
                                    }
                                    selectCity = options[key]
                                    isVisible = true
                                    isSelectCity = true
                                    expanded = false

                            })
                        }
                    }
                }
            if(isVisible) {
                Box(
                    modifier = Modifier
                        .wrapContentSize(Alignment.TopStart)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    LazyColumn{
                        items(40) { index ->
                            apiTempResult = apiListResult?.list?.get(index)?.main?.temp
                            apiFeelsResult = apiListResult?.list?.get(index)?.main?.feels
                            apiGroundResult =
                                apiListResult?.list?.get(index)?.main?.ground.toString()
                            apiHumidityResult =
                                apiListResult?.list?.get(index)?.main?.humidity.toString()
                            apiMainResult =
                                apiListResult?.list?.get(index)?.weather?.get(0)?.main.toString()
                            apiIconResult =
                                apiListResult?.list?.get(index)?.weather?.get(0)?.icon.toString()
                            apiSpeedResult = apiListResult?.list?.get(index)?.wind?.speed.toString()
                            apiDegResult = apiListResult?.list?.get(index)?.wind?.deg.toString()
                            apiGustResult = apiListResult?.list?.get(index)?.wind?.gust.toString()
                            apiPercentResult = apiListResult?.list?.get(index)?.percent.toString()
                            apiTimesResult = apiListResult?.list?.get(index)?.times.toString()
                            apiSnowResult = apiListResult?.list?.get(index)?.snow?.snowfall.toString()
                            if(apiSnowResult == "null") {
                                apiSnowResult = "0"
                            }
                            apiIntTempResult = apiTempResult?.minus(273.15)?.roundToInt()
                            apiIntFeelsResult = apiFeelsResult?.minus(273.15)?.roundToInt()

                            Text(
                                text = "予測時間:$apiTimesResult",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(Color.Gray, shape = CircleShape)
                                    .padding(16.dp),
                                color = Color.White
                                )
                            Text(text = "気温:${apiIntTempResult}℃")
                            Text(text = "体感気温:${apiIntFeelsResult}℃")
                            Text(text = "気圧(陸上):${apiGroundResult}hPa")
                            Text(text = "湿度:${apiHumidityResult}%")
                            Text(text = "天気:$apiMainResult")
                            Image(
                                painter = rememberAsyncImagePainter("https://openweathermap.org/img/w/${apiIconResult}.png"),
                                contentDescription ="Weather Icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(Color.Cyan, shape = CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            Text(text = "風速:${apiSpeedResult}m/s")
                            Text(text = "風向:${apiDegResult}")
                            Text(text = "瞬間風速:${apiGustResult}m/s")
                            Text(text = "降水確率:${apiPercentResult}%")
                            Text(text = "積雪量:${apiSnowResult}mm")
                        }
                    }
                }
            }
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