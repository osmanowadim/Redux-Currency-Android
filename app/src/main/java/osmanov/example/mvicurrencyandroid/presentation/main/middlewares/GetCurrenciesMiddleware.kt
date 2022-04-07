package osmanov.example.mvicurrencyandroid.presentation.main.middlewares

import osmanov.example.mvicurrencyandroid.common.mvi.Middleware
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction

class GetCurrenciesMiddleware(
    private val repository: CurrencyRepositoryContract
) : Middleware<MainAction>() {

    override suspend fun effect(action: MainAction): MainAction? {
        var effect: MainAction? = null
        with(action) {
            if (this is MainAction.GetCurrencies) {
                effect = try {
                    val currencies = repository.getAvailableCurrencies()

                    if (currencies.isNullOrEmpty()) {
                        MainAction.GetCurrenciesDone()
                    } else {
                        MainAction.GetCurrenciesDone(
                            currencies = currencies
                        )
                    }
                } catch (e: Exception) {
                    MainAction.GetCurrenciesDone()
                }
            }
        }

        return effect
    }

}
