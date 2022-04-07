package osmanov.example.mvicurrencyandroid.presentation.main.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.Action
import osmanov.example.mvicurrencyandroid.data.remote.model.CurrencyResponse
import osmanov.example.mvicurrencyandroid.data.remote.model.ExchangeResponse
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

sealed class MainAction : Action {

    object GetCurrencies : MainAction()

    data class CurrencyItemClicked(val currency: CurrencyModel) : MainAction()

    // Effects
    data class GetCurrenciesDone(
        val currencies: List<CurrencyModel>? = null
    ) : MainAction()

}
