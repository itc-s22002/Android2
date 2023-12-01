package jp.ac.it_college.std.s22002.weathermap.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import jp.ac.it_college.std.s22002.weathermap.api.model.WeatherList
object CityGroup {
    suspend fun getCityWeather(gen: String): WeatherList{
        return Client.get(gen).body()
    }
}