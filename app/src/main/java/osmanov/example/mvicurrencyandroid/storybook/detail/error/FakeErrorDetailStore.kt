package osmanov.example.mvicurrencyandroid.storybook.detail.error

import osmanov.example.mvicurrencyandroid.presentation.detail.middlewareas.GetCurrenciesDetailMiddleware
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailStore

/**
 * Fake [DetailStore] for Error Story. Use [FakeErrorDetailReducer] as reducer in MVI.
 */
class FakeErrorDetailStore : DetailStore() {

    init {
        middlewares = listOf(GetCurrenciesDetailMiddleware())
        reducer = FakeErrorDetailReducer()
    }

}
