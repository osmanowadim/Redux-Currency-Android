package osmanov.example.mvicurrencyandroid.storybook.main.error

import osmanov.example.mvicurrencyandroid.common.mvi.Middleware
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction

/**
 * Fake [Middleware] for Error Story. Always return GetCurrenciesDone with empty data.
 */
class FakeErrorGetCurrenciesMiddleware : Middleware<MainAction>() {

    override suspend fun effect(action: MainAction): MainAction? {
        var effect: MainAction? = null
        with(action) {
            if (this is MainAction.GetCurrencies) {
                effect = MainAction.GetCurrenciesDone()
            }
        }
        return effect
    }

}
