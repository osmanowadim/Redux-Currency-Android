package osmanov.example.mvicurrencyandroid.storybook.detail.error

import osmanov.example.mvicurrencyandroid.presentation.detail.middlewareas.GetCurrenciesDetailMiddleware
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailStore

class FakeErrorDetailStore : DetailStore() {

    init {
        middlewares = listOf(GetCurrenciesDetailMiddleware())
        reducer = FakeErrorDetailReducer()
    }

}
