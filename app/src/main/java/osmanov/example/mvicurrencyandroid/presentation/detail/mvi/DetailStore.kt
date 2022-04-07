package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.Store

class DetailStore : Store<DetailState, DetailAction, DetailNews>() {

    init {
        middlewares = listOf()
        reducer = DetailReducer()
    }

}
