package osmanov.example.mvicurrencyandroid.presentation.main.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.Store
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.presentation.main.middlewares.GetCurrenciesMiddleware

class MainStore constructor(
    repository: CurrencyRepositoryContract
) : Store<MainState, MainAction, MainNews>() {

    init {
        middlewares = listOf(GetCurrenciesMiddleware(repository))
        reducer = MainReducer()
    }

}
