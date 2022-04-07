package osmanov.example.mvicurrencyandroid.data.repository

import osmanov.example.mvicurrencyandroid.data.cache.currency.CurrencyCacheContract
import osmanov.example.mvicurrencyandroid.data.remote.ApiRepositoryContract
import osmanov.example.mvicurrencyandroid.data.remote.model.ExchangeResponse
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

/**
 * Repository for Currency data. Here we can add logic for choosing source of data.
 *
 * @param apiRepository - [ApiRepositoryContract] repository for Rest data.
 * @param currencyCache - [CurrencyCacheContract] repository fro Cache data.
 */
class CurrencyRepository(
    private val apiRepository: ApiRepositoryContract,
    private val currencyCache: CurrencyCacheContract
) : CurrencyRepositoryContract {

    //Represent in memory cache
    private var cachedResponse: List<CurrencyModel>? = null

    /**
     * @return List[CurrencyModel] according to in memory cache, DB data or Remote data.
     */
    override suspend fun getAvailableCurrencies(): List<CurrencyModel>? {
        return cachedResponse ?: run {
            val dbCurrencies = currencyCache.getCurrencies()

            dbCurrencies.takeIf { it.isNullOrEmpty().not() } ?: run {
                val restCurrencies = apiRepository.getCurrencies()
                restCurrencies?.let {
                    currencyCache.saveCurrencies(it)
                    cachedResponse = it
                }

                restCurrencies
            }
        }
    }

}
