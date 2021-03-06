package osmanov.example.mvicurrencyandroid.storybook.main.success

import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainReducer
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore

/**
 * Fake [MainStore] for Success Story. Use [FakeSuccessGetCurrenciesMiddleware] as middleware in MVI.
 */
class FakeSuccessMainStore constructor(
    repository: CurrencyRepositoryContract
) : MainStore(repository) {

    init {
        middlewares = listOf(FakeSuccessGetCurrenciesMiddleware())
        reducer = MainReducer()
    }

}
