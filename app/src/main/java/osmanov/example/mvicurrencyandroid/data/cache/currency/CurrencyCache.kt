package osmanov.example.mvicurrencyandroid.data.cache.currency

import osmanov.example.mvicurrencyandroid.data.cache.db.dao.CurrencyDao
import osmanov.example.mvicurrencyandroid.data.mapper.CurrencyEntityMapper
import osmanov.example.mvicurrencyandroid.data.mapper.CurrencyRemoteMapper
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

/**
 * Implementation for [CurrencyCacheContract].
 * Responsibility of this class - working with cached data.
 *
 * @param currencyDao - [CurrencyDao] DAO of Currency in DB.
 * @param currencyEntityMapper - [CurrencyEntityMapper] mapper for DB data.
 */
class CurrencyCache(
    private val currencyDao: CurrencyDao,
    private val currencyEntityMapper: CurrencyEntityMapper
) : CurrencyCacheContract {

    /**
     * @return List[CurrencyModel] - currencies from DB
     */
    override suspend fun getCurrencies(): List<CurrencyModel> {
        return currencyDao.getAllCurrencies().map(currencyEntityMapper::mapToModel)
    }

    /**
     * Save [currencies] to DB.
     *
     * @param currencies - List[CurrencyModel] currencies
     */
    override suspend fun saveCurrencies(currencies: List<CurrencyModel>) {
        currencies.map(currencyEntityMapper::mapFromModel).let {
            currencyDao.insertCurrencies(it)
        }
    }

}
