package osmanov.example.mvicurrencyandroid.presentation.detail.middlewareas

import osmanov.example.mvicurrencyandroid.common.mvi.Middleware
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction

class GetCurrenciesDetailMiddleware : Middleware<DetailAction>() {

    override suspend fun effect(action: DetailAction): DetailAction? {
        var effect: DetailAction? = null
        with(action) {
            if (this is DetailAction.GetCurrencyExchange) {
                effect = DetailAction.GetCurrencyExchangeDone(this.currency)
            }
        }

        return effect
    }

}
