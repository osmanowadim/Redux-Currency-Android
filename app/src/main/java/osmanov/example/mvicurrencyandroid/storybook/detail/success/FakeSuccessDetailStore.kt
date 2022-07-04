package osmanov.example.mvicurrencyandroid.storybook.detail.success

import osmanov.example.mvicurrencyandroid.presentation.detail.middlewareas.GetCurrenciesDetailMiddleware
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailStore

/**
 * Fake [DetailStore] for Success Story. Use [FakeSuccessDetailReducer] as reducer in MVI.
 */
class FakeSuccessDetailStore : DetailStore() {

    init {
        middlewares = listOf(GetCurrenciesDetailMiddleware())
        reducer = FakeSuccessDetailReducer()
    }

}
