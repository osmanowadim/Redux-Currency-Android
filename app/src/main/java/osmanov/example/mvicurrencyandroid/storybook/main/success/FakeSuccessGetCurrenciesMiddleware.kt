package osmanov.example.mvicurrencyandroid.storybook.main.success

import osmanov.example.mvicurrencyandroid.common.mvi.Middleware
import osmanov.example.mvicurrencyandroid.model.CurrencyModel
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction

/**
 * Fake [Middleware] for Success Story. Always return GetCurrenciesDone with fake data.
 */
class FakeSuccessGetCurrenciesMiddleware : Middleware<MainAction>() {

    override suspend fun effect(action: MainAction): MainAction? {
        var effect: MainAction? = null
        with(action) {
            if (this is MainAction.GetCurrencies) {
                effect = MainAction.GetCurrenciesDone(
                    currencies = listOf(
                        CurrencyModel(
                            id = 0,
                            name = "Fake usd",
                            code = "USD",
                            rate = 123.99,
                            exchangeDate = "01.07.2022"
                        ),
                        CurrencyModel(
                            id = 1,
                            name = "Fake euro",
                            code = "EUR",
                            rate = 155.71,
                            exchangeDate = "01.07.2022"
                        ),
                        CurrencyModel(
                            id = 1,
                            name = "Fake Zloltiy",
                            code = "ZLT",
                            rate = 12.55,
                            exchangeDate = "01.07.2022"
                        )
                    )
                )
            }
        }
        return effect
    }

}
