package osmanov.example.mvicurrencyandroid.storybook.main.error

import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainReducer
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore

/**
 * Fake [MainStore] for Error Story. Use [FakeErrorGetCurrenciesMiddleware] as middleware in MVI.
 */
class FakeErrorMainStore constructor(
    repository: CurrencyRepositoryContract
) : MainStore(repository) {

    init {
        middlewares = listOf(FakeErrorGetCurrenciesMiddleware())
        reducer = MainReducer()
    }

}
