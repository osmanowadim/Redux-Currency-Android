package osmanov.example.mvicurrencyandroid.data.remote

import osmanov.example.mvicurrencyandroid.model.CurrencyModel

interface ApiRepositoryContract {

    suspend fun getCurrencies(): List<CurrencyModel>?

}
