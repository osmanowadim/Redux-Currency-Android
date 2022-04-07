package osmanov.example.mvicurrencyandroid.data.repository

import osmanov.example.mvicurrencyandroid.model.CurrencyModel

interface CurrencyRepositoryContract {

    suspend fun getAvailableCurrencies(): List<CurrencyModel>?

}
