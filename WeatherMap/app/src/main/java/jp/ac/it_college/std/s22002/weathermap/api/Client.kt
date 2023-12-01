package jp.ac.it_college.std.s22002.weathermap.api

import androidx.compose.ui.res.stringResource
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import jp.ac.it_college.std.s22002.weathermap.BuildConfig
import kotlinx.serialization.json.Json

object Client {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/forecast?"
    private const val api_key = BuildConfig.API_KEY


    private val ktor = HttpClient(CIO) {
        engine {
            endpoint {
                connectTimeout = 5000
                requestTimeout = 5000
                socketTimeout = 5000
            }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
    }
    suspend fun get(endpoint: String) =
        ktor.get { url("$BASE_URL&id=$endpoint&appid=$api_key&lang=jp") }
}