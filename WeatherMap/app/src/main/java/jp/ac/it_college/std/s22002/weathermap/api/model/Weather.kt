package jp.ac.it_college.std.s22002.weathermap.api.model

import jp.ac.it_college.std.s22002.weathermap.MainActivity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WeatherList(
    val list: List<WeatherInfo>
)

@Serializable
data class WeatherInfo(
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    @SerialName("pop") val percent: Long,
    val snows: Snow,
    @SerialName("dt_txt") val times: String
    )

@Serializable
data class Main(
    val temp: Double,
    @SerialName("feels_like") val feels:Long,
    @SerialName("grnd_level") val ground:Long,
    val humidity: Long

)

@Serializable
data class Weather(
    val main: String,
    val icon: String
)

@Serializable
data class Wind(
    val speed: Long,
    val deg: Long,
    val gust: Long
)

@Serializable
data class Snow(
    @SerialName("3h") val snowfall:Long
)