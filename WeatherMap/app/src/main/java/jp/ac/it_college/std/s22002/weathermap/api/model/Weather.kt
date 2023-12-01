package jp.ac.it_college.std.s22002.weathermap.api.model

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
    @SerialName("pop") val percent: Double,
    val snow: Snow? = (null),
    @SerialName("dt_txt") val times: String
    )

@Serializable
data class Main(
    val temp: Double,
    @SerialName("feels_like") val feels:Double,
    @SerialName("grnd_level") val ground:Double,
    val humidity: String

)

@Serializable
data class Weather(
    val main: String,
    val icon: String
)

@Serializable
data class Wind(
    val speed: Double,
    val deg: Double,
    val gust: Double
)

@Serializable
data class Snow(
    @SerialName("3h") val snowfall:Double?
)