package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.Store
import osmanov.example.mvicurrencyandroid.presentation.detail.middlewareas.GetCurrenciesDetailMiddleware

open class DetailStore : Store<DetailState, DetailAction, DetailNews>() {

    init {
        middlewares = listOf(GetCurrenciesDetailMiddleware())
        reducer = DetailReducer()
    }

}
