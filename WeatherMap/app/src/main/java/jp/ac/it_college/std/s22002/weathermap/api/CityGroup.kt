package jp.ac.it_college.std.s22002.weathermap.api

import io.ktor.client.call.body
import jp.ac.it_college.std.s22002.weathermap.api.model.WeatherList
object CityGroup {
    suspend fun getCityWeather(gen: Int): WeatherList{
        return Client.get("id=$gen").body()
    }
}