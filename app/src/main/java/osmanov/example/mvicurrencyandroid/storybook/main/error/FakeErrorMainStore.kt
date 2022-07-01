package osmanov.example.mvicurrencyandroid.storybook.main.error

import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainReducer
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore

class FakeErrorMainStore constructor(
    repository: CurrencyRepositoryContract
) : MainStore(repository) {

    init {
        middlewares = listOf(FakeErrorGetCurrenciesMiddleware())
        reducer = MainReducer()
    }

}
