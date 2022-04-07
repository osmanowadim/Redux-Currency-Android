package osmanov.example.mvicurrencyandroid.data.cache.currency

import osmanov.example.mvicurrencyandroid.model.CurrencyModel

interface CurrencyCacheContract {

    suspend fun getCurrencies(): List<CurrencyModel>

    suspend fun saveCurrencies(currencies: List<CurrencyModel>)

}
