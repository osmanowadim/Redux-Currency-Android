package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.Action
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

sealed class DetailAction : Action {

    data class GetCurrencyExchange(
        val currency: CurrencyModel?
    ) : DetailAction()

    // Effects
    data class GetCurrencyExchangeDone(
        val currency: CurrencyModel?
    ) : DetailAction()

}
