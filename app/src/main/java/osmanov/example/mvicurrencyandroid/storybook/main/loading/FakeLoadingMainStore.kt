package osmanov.example.mvicurrencyandroid.storybook.main.loading

import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainReducer
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore

class FakeLoadingMainStore constructor(
    repository: CurrencyRepositoryContract
) : MainStore(repository) {

    init {
        middlewares = listOf(FakeLoadingGetCurrenciesMiddleware())
        reducer = MainReducer()
    }

}
