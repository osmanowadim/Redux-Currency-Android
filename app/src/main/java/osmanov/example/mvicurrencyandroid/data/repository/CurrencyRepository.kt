package osmanov.example.mvicurrencyandroid.data.repository

import osmanov.example.mvicurrencyandroid.data.cache.currency.CurrencyCacheContract
import osmanov.example.mvicurrencyandroid.data.remote.ApiRepositoryContract
import osmanov.example.mvicurrencyandroid.model.CurrencyModel
import java.util.*

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

    //Label for saved data timestamp
    private var cachedTime: Long? = null

    //Timestamp for cached data
    private val updateTimestamp = 60_000L

    /**
     * @return List[CurrencyModel] according to in memory cache, DB data or Remote data.
     */
    override suspend fun getAvailableCurrencies(): List<CurrencyModel>? {
        return cachedResponse?.takeIf { it.isNullOrEmpty().not() && isActualDate(cachedTime) }
            ?: run {
                val dbCurrencies = currencyCache.getCurrencies()

                dbCurrencies.takeIf {
                    it.isNullOrEmpty().not() && isActualDate(cachedTime)
                } ?: run {
                    getRemoteCurrencies()?.let {
                        updateCurrentTimestamp()
                        currencyCache.saveCurrencies(it)
                        cachedResponse = it
                    }

                    cachedResponse
                }
            }
    }

    /**
     * Set current saved timestamp [cachedTime] to Date().time.
     */
    override fun updateCurrentTimestamp() {
        cachedTime = Date().time
    }

    /**
     * @return List[CurrencyModel] from [apiRepository].
     */
    private suspend fun getRemoteCurrencies(): List<CurrencyModel>? {
        return apiRepository.getCurrencies()
    }

    /**
     * @return true - if [time] is actual.
     * @return false - otherwise.
     *
     * @param time - [Long] timestamp for cached data.
     */
    private fun isActualDate(time: Long?): Boolean {
        if (time == null) return false

        return (Date().time - time) <= updateTimestamp
    }

}
