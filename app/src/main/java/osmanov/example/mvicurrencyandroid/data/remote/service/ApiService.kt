package osmanov.example.mvicurrencyandroid.data.remote.service

import kotlinx.coroutines.Deferred
import osmanov.example.mvicurrencyandroid.data.remote.model.ExchangeResponse
import retrofit2.http.GET

/**
 * Service for all rest calls
 */
interface ApiService {

    @GET("exchange")
    fun getCurrenciesAsync(): Deferred<ExchangeResponse>

}
