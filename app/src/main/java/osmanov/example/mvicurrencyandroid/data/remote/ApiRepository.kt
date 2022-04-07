package osmanov.example.mvicurrencyandroid.data.remote

import osmanov.example.mvicurrencyandroid.data.mapper.CurrencyRemoteMapper
import osmanov.example.mvicurrencyandroid.data.remote.service.ApiService
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

/**
 * Repository for Remote calls.
 *
 * @param apiService - [ApiService] service for REST calls.
 * @param currencyMapper - [CurrencyRemoteMapper] mapper for Remote currencies
 */
class ApiRepository(
    private val apiService: ApiService,
    private val currencyMapper: CurrencyRemoteMapper
) : ApiRepositoryContract {

    /**
     * @return List[CurrencyModel] from Rest call mapped by [currencyMapper]
     */
    override suspend fun getCurrencies(): List<CurrencyModel>? =
        apiService.getCurrenciesAsync().await().currency?.map(currencyMapper::mapToModel)

}
